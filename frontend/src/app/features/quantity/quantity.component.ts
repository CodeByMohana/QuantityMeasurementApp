import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SharedModule } from '../../shared/shared.module';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-quantity',
  standalone: true,
  imports: [SharedModule, MatTabsModule],
  templateUrl: './quantity.component.html'
})
export class QuantityComponent {
  convertForm: FormGroup;
  compareForm: FormGroup;
  arithmeticForm: FormGroup;
  
  measurementTypes = ['LENGTH', 'WEIGHT', 'VOLUME', 'TEMPERATURE'];
  
  unitsMap: { [key: string]: string[] } = {
    'LENGTH': ['INCHES', 'FEET', 'YARDS', 'CENTIMETERS', 'METERS'],
    'WEIGHT': ['GRAM', 'KILOGRAM', 'POUND', 'OUNCE'],
    'VOLUME': ['GALLON', 'LITER', 'MILLILITER'],
    'TEMPERATURE': ['CELSIUS', 'FAHRENHEIT', 'KELVIN']
  };

  convertUnits: string[] = [];
  compareUnits: string[] = [];
  arithmeticUnits: string[] = [];

  convertResult: any = null;
  compareResult: boolean | null = null;
  arithmeticResult: any = null;
  loading = false;

  constructor(private fb: FormBuilder, private http: HttpClient, private snackBar: MatSnackBar) {
    this.convertForm = this.fb.group({
      measurementType: ['LENGTH', Validators.required],
      value: [null, Validators.required],
      fromUnit: ['', Validators.required],
      toUnit: ['', Validators.required]
    });

    this.compareForm = this.fb.group({
      measurementType: ['LENGTH', Validators.required],
      value1: [null, Validators.required],
      unit1: ['', Validators.required],
      value2: [null, Validators.required],
      unit2: ['', Validators.required]
    });

    this.arithmeticForm = this.fb.group({
      measurementType: ['LENGTH', Validators.required],
      operation: ['add', Validators.required],
      value1: [null, Validators.required],
      unit1: ['', Validators.required],
      value2: [null, Validators.required],
      unit2: ['', Validators.required]
    });

    // Initialize units
    this.convertUnits = this.unitsMap['LENGTH'];
    this.compareUnits = this.unitsMap['LENGTH'];
    this.arithmeticUnits = this.unitsMap['LENGTH'];

    // Listen for type changes
    this.convertForm.get('measurementType')?.valueChanges.subscribe(type => {
      this.convertUnits = this.unitsMap[type];
      this.convertForm.patchValue({ fromUnit: '', toUnit: '' });
      this.convertResult = null;
    });

    this.compareForm.get('measurementType')?.valueChanges.subscribe(type => {
      this.compareUnits = this.unitsMap[type];
      this.compareForm.patchValue({ unit1: '', unit2: '' });
      this.compareResult = null;
    });

    this.arithmeticForm.get('measurementType')?.valueChanges.subscribe(type => {
      this.arithmeticUnits = this.unitsMap[type];
      this.arithmeticForm.patchValue({ unit1: '', unit2: '' });
      this.arithmeticResult = null;
    });
  }

  doConvert() {
    if (this.convertForm.invalid) return;
    this.loading = true;
    
    const payload = {
      quantity: {
        value: this.convertForm.value.value,
        unit: this.convertForm.value.fromUnit,
        measurementType: this.convertForm.value.measurementType
      },
      targetUnit: this.convertForm.value.toUnit
    };

    this.http.post<any>('http://54.206.167.226:8080/api/quantity/convert', payload).subscribe({
      next: (res) => {
        this.loading = false;
        this.convertResult = res;
      },
      error: (err) => {
        this.loading = false;
        this.snackBar.open(err.error?.message || 'Conversion failed', 'Close', { duration: 5000 });
      }
    });
  }

  doCompare() {
    if (this.compareForm.invalid) return;
    this.loading = true;

    const payload = {
      q1: {
        value: this.compareForm.value.value1,
        unit: this.compareForm.value.unit1,
        measurementType: this.compareForm.value.measurementType
      },
      q2: {
        value: this.compareForm.value.value2,
        unit: this.compareForm.value.unit2,
        measurementType: this.compareForm.value.measurementType
      }
    };

    this.http.post<boolean>('http://54.206.167.226:8080/api/quantity/compare', payload).subscribe({
      next: (res) => {
        this.loading = false;
        this.compareResult = res;
      },
      error: (err) => {
        this.loading = false;
        this.snackBar.open(err.error?.message || 'Comparison failed', 'Close', { duration: 5000 });
      }
    });
  }

  doArithmetic() {
    if (this.arithmeticForm.invalid) return;
    this.loading = true;

    const payload = {
      q1: {
        value: this.arithmeticForm.value.value1,
        unit: this.arithmeticForm.value.unit1,
        measurementType: this.arithmeticForm.value.measurementType
      },
      q2: {
        value: this.arithmeticForm.value.value2,
        unit: this.arithmeticForm.value.unit2,
        measurementType: this.arithmeticForm.value.measurementType
      }
    };

    const endpoint = this.arithmeticForm.value.operation;

    this.http.post<any>(`http://54.206.167.226:8080/api/quantity/${endpoint}`, payload).subscribe({
      next: (res) => {
        this.loading = false;
        this.arithmeticResult = res;
      },
      error: (err) => {
        this.loading = false;
        this.snackBar.open(err.error?.message || 'Arithmetic operation failed', 'Close', { duration: 5000 });
      }
    });
  }
}
