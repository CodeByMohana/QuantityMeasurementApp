import{B as le,D as de,E as ce,H as me,I as be,J as pe,K as ue,L as he,M as _e,N as ht,O as fe,P as ge,U as ve,a as jt,b as _,c as Wt,d as Ut,e as $t,f as Zt,g as Kt,h as Yt,i as Xt,j as bt,k as Jt,ka as ye,l as te,la as xe,oa as Te,q as pt,r as ee,s as ne,t as ae,u as ie,v as re,w as oe,x as J,y as ut,z as se}from"./chunk-2PN2VXAB.js";import{g as Qt,h as zt,i as Gt,m as Vt,s as qt}from"./chunk-6HCZ2JXB.js";import{$b as d,Ab as o,Bb as v,C as Dt,Ib as lt,M as Mt,Mb as y,N as z,Nb as g,O as St,Ob as W,P,Pb as U,Qb as $,Ra as l,Rb as N,Sb as u,Tb as h,W as Rt,Wa as V,Xa as q,Xb as dt,Y as S,Yb as Ht,Za as nt,Zb as C,_ as b,_a as j,_b as Z,a as E,ab as Pt,ac as f,bc as K,c as Ct,da as R,dc as H,e as O,ea as B,eb as D,ec as Ot,fb as Ft,fc as ct,gb as M,ha as et,hc as mt,ib as A,j as kt,jb as p,kb as At,l as It,la as T,ma as F,rb as Nt,sb as I,ta as Bt,tb as at,tc as Y,ua as G,ub as it,vb as rt,w as wt,wa as L,wb as ot,x as Q,xa as Lt,xb as st,xc as x,y as Et,yb as c,yc as X,zb as r}from"./chunk-K54ILAC2.js";import"./chunk-7CGTOI24.js";var yt=["*"];function Fe(a,s){a&1&&U(0)}var Ae=["tabListContainer"],Ne=["tabList"],He=["tabListInner"],Oe=["nextPaginator"],Qe=["previousPaginator"],ze=["content"];function Ge(a,s){}var Ve=["tabBodyWrapper"],qe=["tabHeader"];function je(a,s){}function We(a,s){if(a&1&&p(0,je,0,0,"ng-template",12),a&2){let t=g().$implicit;c("cdkPortalOutlet",t.templateLabel)}}function Ue(a,s){if(a&1&&d(0),a&2){let t=g().$implicit;f(t.textLabel)}}function $e(a,s){if(a&1){let t=lt();r(0,"div",7,2),y("click",function(){let n=R(t),i=n.$implicit,m=n.$index,k=g(),w=dt(1);return B(k._handleClick(i,w,m))})("cdkFocusChange",function(n){let i=R(t).$index,m=g();return B(m._tabFocusChanged(n,i))}),v(2,"span",8)(3,"div",9),r(4,"span",10)(5,"span",11),at(6,We,1,1,null,12)(7,Ue,1,1),o()()()}if(a&2){let t=s.$implicit,e=s.$index,n=dt(1),i=g();Z(t.labelClass),C("mdc-tab--active",i.selectedIndex===e),c("id",i._getTabLabelId(t,e))("disabled",t.disabled)("fitInkBarToContent",i.fitInkBarToContent),I("tabIndex",i._getTabIndex(e))("aria-posinset",e+1)("aria-setsize",i._tabs.length)("aria-controls",i._getTabContentId(e))("aria-selected",i.selectedIndex===e)("aria-label",t.ariaLabel||null)("aria-labelledby",!t.ariaLabel&&t.ariaLabelledby?t.ariaLabelledby:null),l(3),c("matRippleTrigger",n)("matRippleDisabled",t.disabled||i.disableRipple),l(3),it(t.templateLabel?6:7)}}function Ze(a,s){a&1&&U(0)}function Ke(a,s){if(a&1){let t=lt();r(0,"mat-tab-body",13),y("_onCentered",function(){R(t);let n=g();return B(n._removeTabBodyWrapperHeight())})("_onCentering",function(n){R(t);let i=g();return B(i._setTabBodyWrapperHeight(n))})("_beforeCentering",function(n){R(t);let i=g();return B(i._bodyCentered(n))}),o()}if(a&2){let t=s.$implicit,e=s.$index,n=g();Z(t.bodyClass),c("id",n._getTabContentId(e))("content",t.content)("position",t.position)("animationDuration",n.animationDuration)("preserveContent",n.preserveContent),I("tabindex",n.contentTabIndex!=null&&n.selectedIndex===e?n.contentTabIndex:null)("aria-labelledby",n._getTabLabelId(t,e))("aria-hidden",n.selectedIndex!==e)}}var Ye=new S("MatTabContent"),Xe=(()=>{class a{template=b(q);constructor(){}static \u0275fac=function(e){return new(e||a)};static \u0275dir=M({type:a,selectors:[["","matTabContent",""]],features:[H([{provide:Ye,useExisting:a}])]})}return a})(),Je=new S("MatTabLabel"),we=new S("MAT_TAB"),tn=(()=>{class a extends _e{_closestTab=b(we,{optional:!0});static \u0275fac=(()=>{let t;return function(n){return(t||(t=G(a)))(n||a)}})();static \u0275dir=M({type:a,selectors:[["","mat-tab-label",""],["","matTabLabel",""]],features:[H([{provide:Je,useExisting:a}]),A]})}return a})(),Ee=new S("MAT_TAB_GROUP"),xt=(()=>{class a{_viewContainerRef=b(Pt);_closestTabGroup=b(Ee,{optional:!0});disabled=!1;get templateLabel(){return this._templateLabel}set templateLabel(t){this._setTemplateLabelInput(t)}_templateLabel;_explicitContent=void 0;_implicitContent;textLabel="";ariaLabel;ariaLabelledby;labelClass;bodyClass;id=null;_contentPortal=null;get content(){return this._contentPortal}_stateChanges=new O;position=null;origin=null;isActive=!1;constructor(){b(ne).load(se)}ngOnChanges(t){(t.hasOwnProperty("textLabel")||t.hasOwnProperty("disabled"))&&this._stateChanges.next()}ngOnDestroy(){this._stateChanges.complete()}ngOnInit(){this._contentPortal=new he(this._explicitContent||this._implicitContent,this._viewContainerRef)}_setTemplateLabelInput(t){t&&t._closestTab===this&&(this._templateLabel=t)}static \u0275fac=function(e){return new(e||a)};static \u0275cmp=D({type:a,selectors:[["mat-tab"]],contentQueries:function(e,n,i){if(e&1&&$(i,tn,5)(i,Xe,7,q),e&2){let m;u(m=h())&&(n.templateLabel=m.first),u(m=h())&&(n._explicitContent=m.first)}},viewQuery:function(e,n){if(e&1&&N(q,7),e&2){let i;u(i=h())&&(n._implicitContent=i.first)}},hostAttrs:["hidden",""],hostVars:1,hostBindings:function(e,n){e&2&&I("id",null)},inputs:{disabled:[2,"disabled","disabled",x],textLabel:[0,"label","textLabel"],ariaLabel:[0,"aria-label","ariaLabel"],ariaLabelledby:[0,"aria-labelledby","ariaLabelledby"],labelClass:"labelClass",bodyClass:"bodyClass",id:"id"},exportAs:["matTab"],features:[H([{provide:we,useExisting:a}]),Bt],ngContentSelectors:yt,decls:1,vars:0,template:function(e,n){e&1&&(W(),At(0,Fe,1,0,"ng-template"))},encapsulation:2})}return a})(),_t="mdc-tab-indicator--active",Ce="mdc-tab-indicator--no-transition",ft=class{_items;_currentItem;constructor(s){this._items=s}hide(){this._items.forEach(s=>s.deactivateInkBar()),this._currentItem=void 0}alignToElement(s){let t=this._items.find(n=>n.elementRef.nativeElement===s),e=this._currentItem;if(t!==e&&(e?.deactivateInkBar(),t)){let n=e?.elementRef.nativeElement.getBoundingClientRect?.();t.activateInkBar(n),this._currentItem=t}}},en=(()=>{class a{_elementRef=b(L);_inkBarElement=null;_inkBarContentElement=null;_fitToContent=!1;get fitInkBarToContent(){return this._fitToContent}set fitInkBarToContent(t){this._fitToContent!==t&&(this._fitToContent=t,this._inkBarElement&&this._appendInkBarElement())}activateInkBar(t){let e=this._elementRef.nativeElement;if(!t||!e.getBoundingClientRect||!this._inkBarContentElement){e.classList.add(_t);return}let n=e.getBoundingClientRect(),i=t.width/n.width,m=t.left-n.left;e.classList.add(Ce),this._inkBarContentElement.style.setProperty("transform",`translateX(${m}px) scaleX(${i})`),e.getBoundingClientRect(),e.classList.remove(Ce),e.classList.add(_t),this._inkBarContentElement.style.setProperty("transform","")}deactivateInkBar(){this._elementRef.nativeElement.classList.remove(_t)}ngOnInit(){this._createInkBarElement()}ngOnDestroy(){this._inkBarElement?.remove(),this._inkBarElement=this._inkBarContentElement=null}_createInkBarElement(){let t=this._elementRef.nativeElement.ownerDocument||document,e=this._inkBarElement=t.createElement("span"),n=this._inkBarContentElement=t.createElement("span");e.className="mdc-tab-indicator",n.className="mdc-tab-indicator__content mdc-tab-indicator__content--underline",e.appendChild(this._inkBarContentElement),this._appendInkBarElement()}_appendInkBarElement(){this._inkBarElement;let t=this._fitToContent?this._elementRef.nativeElement.querySelector(".mdc-tab__content"):this._elementRef.nativeElement;t.appendChild(this._inkBarElement)}static \u0275fac=function(e){return new(e||a)};static \u0275dir=M({type:a,inputs:{fitInkBarToContent:[2,"fitInkBarToContent","fitInkBarToContent",x]}})}return a})();var De=(()=>{class a extends en{elementRef=b(L);disabled=!1;focus(){this.elementRef.nativeElement.focus()}getOffsetLeft(){return this.elementRef.nativeElement.offsetLeft}getOffsetWidth(){return this.elementRef.nativeElement.offsetWidth}static \u0275fac=(()=>{let t;return function(n){return(t||(t=G(a)))(n||a)}})();static \u0275dir=M({type:a,selectors:[["","matTabLabelWrapper",""]],hostVars:3,hostBindings:function(e,n){e&2&&(I("aria-disabled",!!n.disabled),C("mat-mdc-tab-disabled",n.disabled))},inputs:{disabled:[2,"disabled","disabled",x]},features:[A]})}return a})(),ke={passive:!0},nn=650,an=100,rn=(()=>{class a{_elementRef=b(L);_changeDetectorRef=b(Y);_viewportRuler=b(ue);_dir=b(bt,{optional:!0});_ngZone=b(F);_platform=b(pt);_sharedResizeObserver=b(de);_injector=b(et);_renderer=b(nt);_animationsDisabled=J();_eventCleanups;_scrollDistance=0;_selectedIndexChanged=!1;_destroyed=new O;_showPaginationControls=!1;_disableScrollAfter=!0;_disableScrollBefore=!0;_tabLabelCount;_scrollDistanceChanged=!1;_keyManager;_currentTextContent;_stopScrolling=new O;disablePagination=!1;get selectedIndex(){return this._selectedIndex}set selectedIndex(t){let e=isNaN(t)?0:t;this._selectedIndex!=e&&(this._selectedIndexChanged=!0,this._selectedIndex=e,this._keyManager&&this._keyManager.updateActiveItem(e))}_selectedIndex=0;selectFocusedIndex=new T;indexFocused=new T;constructor(){this._eventCleanups=this._ngZone.runOutsideAngular(()=>[this._renderer.listen(this._elementRef.nativeElement,"mouseleave",()=>this._stopInterval())])}ngAfterViewInit(){this._eventCleanups.push(this._renderer.listen(this._previousPaginator.nativeElement,"touchstart",()=>this._handlePaginatorPress("before"),ke),this._renderer.listen(this._nextPaginator.nativeElement,"touchstart",()=>this._handlePaginatorPress("after"),ke))}ngAfterContentInit(){let t=this._dir?this._dir.change:It("ltr"),e=this._sharedResizeObserver.observe(this._elementRef.nativeElement).pipe(Dt(32),P(this._destroyed)),n=this._viewportRuler.change(150).pipe(P(this._destroyed)),i=()=>{this.updatePagination(),this._alignInkBarToSelectedTab()};this._keyManager=new re(this._items).withHorizontalOrientation(this._getLayoutDirection()).withHomeAndEnd().withWrap().skipPredicate(()=>!1),this._keyManager.updateActiveItem(Math.max(this._selectedIndex,0)),V(i,{injector:this._injector}),Q(t,n,e,this._items.changes,this._itemsResized()).pipe(P(this._destroyed)).subscribe(()=>{this._ngZone.run(()=>{Promise.resolve().then(()=>{this._scrollDistance=Math.max(0,Math.min(this._getMaxScrollDistance(),this._scrollDistance)),i()})}),this._keyManager?.withHorizontalOrientation(this._getLayoutDirection())}),this._keyManager.change.subscribe(m=>{this.indexFocused.emit(m),this._setTabFocus(m)})}_itemsResized(){return typeof ResizeObserver!="function"?kt:this._items.changes.pipe(z(this._items),St(t=>new Ct(e=>this._ngZone.runOutsideAngular(()=>{let n=new ResizeObserver(i=>e.next(i));return t.forEach(i=>n.observe(i.elementRef.nativeElement)),()=>{n.disconnect()}}))),Mt(1),Et(t=>t.some(e=>e.contentRect.width>0&&e.contentRect.height>0)))}ngAfterContentChecked(){this._tabLabelCount!=this._items.length&&(this.updatePagination(),this._tabLabelCount=this._items.length,this._changeDetectorRef.markForCheck()),this._selectedIndexChanged&&(this._scrollToLabel(this._selectedIndex),this._checkScrollingControls(),this._alignInkBarToSelectedTab(),this._selectedIndexChanged=!1,this._changeDetectorRef.markForCheck()),this._scrollDistanceChanged&&(this._updateTabScrollPosition(),this._scrollDistanceChanged=!1,this._changeDetectorRef.markForCheck())}ngOnDestroy(){this._eventCleanups.forEach(t=>t()),this._keyManager?.destroy(),this._destroyed.next(),this._destroyed.complete(),this._stopScrolling.complete()}_handleKeydown(t){if(!ie(t))switch(t.keyCode){case 13:case 32:if(this.focusIndex!==this.selectedIndex){let e=this._items.get(this.focusIndex);e&&!e.disabled&&(this.selectFocusedIndex.emit(this.focusIndex),this._itemSelected(t))}break;default:this._keyManager?.onKeydown(t)}}_onContentChanges(){let t=this._elementRef.nativeElement.textContent;t!==this._currentTextContent&&(this._currentTextContent=t||"",this._ngZone.run(()=>{this.updatePagination(),this._alignInkBarToSelectedTab(),this._changeDetectorRef.markForCheck()}))}updatePagination(){this._checkPaginationEnabled(),this._checkScrollingControls(),this._updateTabScrollPosition()}get focusIndex(){return this._keyManager?this._keyManager.activeItemIndex:0}set focusIndex(t){!this._isValidIndex(t)||this.focusIndex===t||!this._keyManager||this._keyManager.setActiveItem(t)}_isValidIndex(t){return this._items?!!this._items.toArray()[t]:!0}_setTabFocus(t){if(this._showPaginationControls&&this._scrollToLabel(t),this._items&&this._items.length){this._items.toArray()[t].focus();let e=this._tabListContainer.nativeElement;this._getLayoutDirection()=="ltr"?e.scrollLeft=0:e.scrollLeft=e.scrollWidth-e.offsetWidth}}_getLayoutDirection(){return this._dir&&this._dir.value==="rtl"?"rtl":"ltr"}_updateTabScrollPosition(){if(this.disablePagination)return;let t=this.scrollDistance,e=this._getLayoutDirection()==="ltr"?-t:t;this._tabList.nativeElement.style.transform=`translateX(${Math.round(e)}px)`,(this._platform.TRIDENT||this._platform.EDGE)&&(this._tabListContainer.nativeElement.scrollLeft=0)}get scrollDistance(){return this._scrollDistance}set scrollDistance(t){this._scrollTo(t)}_scrollHeader(t){let e=this._tabListContainer.nativeElement.offsetWidth,n=(t=="before"?-1:1)*e/3;return this._scrollTo(this._scrollDistance+n)}_handlePaginatorClick(t){this._stopInterval(),this._scrollHeader(t)}_scrollToLabel(t){if(this.disablePagination)return;let e=this._items?this._items.toArray()[t]:null;if(!e)return;let n=this._tabListContainer.nativeElement.offsetWidth,{offsetLeft:i,offsetWidth:m}=e.elementRef.nativeElement,k,w;this._getLayoutDirection()=="ltr"?(k=i,w=k+m):(w=this._tabListInner.nativeElement.offsetWidth-i,k=w-m);let tt=this.scrollDistance,Tt=this.scrollDistance+n;k<tt?this.scrollDistance-=tt-k:w>Tt&&(this.scrollDistance+=Math.min(w-Tt,k-tt))}_checkPaginationEnabled(){if(this.disablePagination)this._showPaginationControls=!1;else{let t=this._tabListInner.nativeElement.scrollWidth,e=this._elementRef.nativeElement.offsetWidth,n=t-e>=5;n||(this.scrollDistance=0),n!==this._showPaginationControls&&(this._showPaginationControls=n,this._changeDetectorRef.markForCheck())}}_checkScrollingControls(){this.disablePagination?this._disableScrollAfter=this._disableScrollBefore=!0:(this._disableScrollBefore=this.scrollDistance==0,this._disableScrollAfter=this.scrollDistance==this._getMaxScrollDistance(),this._changeDetectorRef.markForCheck())}_getMaxScrollDistance(){let t=this._tabListInner.nativeElement.scrollWidth,e=this._tabListContainer.nativeElement.offsetWidth;return t-e||0}_alignInkBarToSelectedTab(){let t=this._items&&this._items.length?this._items.toArray()[this.selectedIndex]:null,e=t?t.elementRef.nativeElement:null;e?this._inkBar.alignToElement(e):this._inkBar.hide()}_stopInterval(){this._stopScrolling.next()}_handlePaginatorPress(t,e){e&&e.button!=null&&e.button!==0||(this._stopInterval(),wt(nn,an).pipe(P(Q(this._stopScrolling,this._destroyed))).subscribe(()=>{let{maxScrollDistance:n,distance:i}=this._scrollHeader(t);(i===0||i>=n)&&this._stopInterval()}))}_scrollTo(t){if(this.disablePagination)return{maxScrollDistance:0,distance:0};let e=this._getMaxScrollDistance();return this._scrollDistance=Math.max(0,Math.min(e,t)),this._scrollDistanceChanged=!0,this._checkScrollingControls(),{maxScrollDistance:e,distance:this._scrollDistance}}static \u0275fac=function(e){return new(e||a)};static \u0275dir=M({type:a,inputs:{disablePagination:[2,"disablePagination","disablePagination",x],selectedIndex:[2,"selectedIndex","selectedIndex",X]},outputs:{selectFocusedIndex:"selectFocusedIndex",indexFocused:"indexFocused"}})}return a})(),on=(()=>{class a extends rn{_items;_tabListContainer;_tabList;_tabListInner;_nextPaginator;_previousPaginator;_inkBar;ariaLabel;ariaLabelledby;disableRipple=!1;ngAfterContentInit(){this._inkBar=new ft(this._items),super.ngAfterContentInit()}_itemSelected(t){t.preventDefault()}static \u0275fac=(()=>{let t;return function(n){return(t||(t=G(a)))(n||a)}})();static \u0275cmp=D({type:a,selectors:[["mat-tab-header"]],contentQueries:function(e,n,i){if(e&1&&$(i,De,4),e&2){let m;u(m=h())&&(n._items=m)}},viewQuery:function(e,n){if(e&1&&N(Ae,7)(Ne,7)(He,7)(Oe,5)(Qe,5),e&2){let i;u(i=h())&&(n._tabListContainer=i.first),u(i=h())&&(n._tabList=i.first),u(i=h())&&(n._tabListInner=i.first),u(i=h())&&(n._nextPaginator=i.first),u(i=h())&&(n._previousPaginator=i.first)}},hostAttrs:[1,"mat-mdc-tab-header"],hostVars:4,hostBindings:function(e,n){e&2&&C("mat-mdc-tab-header-pagination-controls-enabled",n._showPaginationControls)("mat-mdc-tab-header-rtl",n._getLayoutDirection()=="rtl")},inputs:{ariaLabel:[0,"aria-label","ariaLabel"],ariaLabelledby:[0,"aria-labelledby","ariaLabelledby"],disableRipple:[2,"disableRipple","disableRipple",x]},features:[A],ngContentSelectors:yt,decls:13,vars:10,consts:[["previousPaginator",""],["tabListContainer",""],["tabList",""],["tabListInner",""],["nextPaginator",""],["mat-ripple","",1,"mat-mdc-tab-header-pagination","mat-mdc-tab-header-pagination-before",3,"click","mousedown","touchend","matRippleDisabled"],[1,"mat-mdc-tab-header-pagination-chevron"],[1,"mat-mdc-tab-label-container",3,"keydown"],["role","tablist",1,"mat-mdc-tab-list",3,"cdkObserveContent"],[1,"mat-mdc-tab-labels"],["mat-ripple","",1,"mat-mdc-tab-header-pagination","mat-mdc-tab-header-pagination-after",3,"mousedown","click","touchend","matRippleDisabled"]],template:function(e,n){e&1&&(W(),r(0,"div",5,0),y("click",function(){return n._handlePaginatorClick("before")})("mousedown",function(m){return n._handlePaginatorPress("before",m)})("touchend",function(){return n._stopInterval()}),v(2,"div",6),o(),r(3,"div",7,1),y("keydown",function(m){return n._handleKeydown(m)}),r(5,"div",8,2),y("cdkObserveContent",function(){return n._onContentChanges()}),r(7,"div",9,3),U(9),o()()(),r(10,"div",10,4),y("mousedown",function(m){return n._handlePaginatorPress("after",m)})("click",function(){return n._handlePaginatorClick("after")})("touchend",function(){return n._stopInterval()}),v(12,"div",6),o()),e&2&&(C("mat-mdc-tab-header-pagination-disabled",n._disableScrollBefore),c("matRippleDisabled",n._disableScrollBefore||n.disableRipple),l(3),C("_mat-animation-noopable",n._animationsDisabled),l(2),I("aria-label",n.ariaLabel||null)("aria-labelledby",n.ariaLabelledby||null),l(5),C("mat-mdc-tab-header-pagination-disabled",n._disableScrollAfter),c("matRippleDisabled",n._disableScrollAfter||n.disableRipple))},dependencies:[ut,ae],styles:[`.mat-mdc-tab-header {
  display: flex;
  overflow: hidden;
  position: relative;
  flex-shrink: 0;
}

.mdc-tab-indicator .mdc-tab-indicator__content {
  transition-duration: var(--mat-tab-animation-duration, 250ms);
}

.mat-mdc-tab-header-pagination {
  -webkit-user-select: none;
  user-select: none;
  position: relative;
  display: none;
  justify-content: center;
  align-items: center;
  min-width: 32px;
  cursor: pointer;
  z-index: 2;
  -webkit-tap-highlight-color: transparent;
  touch-action: none;
  box-sizing: content-box;
  outline: 0;
}
.mat-mdc-tab-header-pagination::-moz-focus-inner {
  border: 0;
}
.mat-mdc-tab-header-pagination .mat-ripple-element {
  opacity: 0.12;
  background-color: var(--mat-tab-inactive-ripple-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab-header-pagination-controls-enabled .mat-mdc-tab-header-pagination {
  display: flex;
}

.mat-mdc-tab-header-pagination-before,
.mat-mdc-tab-header-rtl .mat-mdc-tab-header-pagination-after {
  padding-left: 4px;
}
.mat-mdc-tab-header-pagination-before .mat-mdc-tab-header-pagination-chevron,
.mat-mdc-tab-header-rtl .mat-mdc-tab-header-pagination-after .mat-mdc-tab-header-pagination-chevron {
  transform: rotate(-135deg);
}

.mat-mdc-tab-header-rtl .mat-mdc-tab-header-pagination-before,
.mat-mdc-tab-header-pagination-after {
  padding-right: 4px;
}
.mat-mdc-tab-header-rtl .mat-mdc-tab-header-pagination-before .mat-mdc-tab-header-pagination-chevron,
.mat-mdc-tab-header-pagination-after .mat-mdc-tab-header-pagination-chevron {
  transform: rotate(45deg);
}

.mat-mdc-tab-header-pagination-chevron {
  border-style: solid;
  border-width: 2px 2px 0 0;
  height: 8px;
  width: 8px;
  border-color: var(--mat-tab-pagination-icon-color, var(--mat-sys-on-surface));
}

.mat-mdc-tab-header-pagination-disabled {
  box-shadow: none;
  cursor: default;
  pointer-events: none;
}
.mat-mdc-tab-header-pagination-disabled .mat-mdc-tab-header-pagination-chevron {
  opacity: 0.4;
}

.mat-mdc-tab-list {
  flex-grow: 1;
  position: relative;
  transition: transform 500ms cubic-bezier(0.35, 0, 0.25, 1);
}
._mat-animation-noopable .mat-mdc-tab-list {
  transition: none;
}

.mat-mdc-tab-label-container {
  display: flex;
  flex-grow: 1;
  overflow: hidden;
  z-index: 1;
  border-bottom-style: solid;
  border-bottom-width: var(--mat-tab-divider-height, 1px);
  border-bottom-color: var(--mat-tab-divider-color, var(--mat-sys-surface-variant));
}
.mat-mdc-tab-group-inverted-header .mat-mdc-tab-label-container {
  border-bottom: none;
  border-top-style: solid;
  border-top-width: var(--mat-tab-divider-height, 1px);
  border-top-color: var(--mat-tab-divider-color, var(--mat-sys-surface-variant));
}

.mat-mdc-tab-labels {
  display: flex;
  flex: 1 0 auto;
}
[mat-align-tabs=center] > .mat-mdc-tab-header .mat-mdc-tab-labels {
  justify-content: center;
}
[mat-align-tabs=end] > .mat-mdc-tab-header .mat-mdc-tab-labels {
  justify-content: flex-end;
}
.cdk-drop-list .mat-mdc-tab-labels, .mat-mdc-tab-labels.cdk-drop-list {
  min-height: var(--mat-tab-container-height, 48px);
}

.mat-mdc-tab::before {
  margin: 5px;
}
@media (forced-colors: active) {
  .mat-mdc-tab[aria-disabled=true] {
    color: GrayText;
  }
}
`],encapsulation:2})}return a})(),sn=new S("MAT_TABS_CONFIG"),Ie=(()=>{class a extends ht{_host=b(gt);_ngZone=b(F);_centeringSub=E.EMPTY;_leavingSub=E.EMPTY;constructor(){super()}ngOnInit(){super.ngOnInit(),this._centeringSub=this._host._beforeCentering.pipe(z(this._host._isCenterPosition())).subscribe(t=>{this._host._content&&t&&!this.hasAttached()&&this._ngZone.run(()=>{Promise.resolve().then(),this.attach(this._host._content)})}),this._leavingSub=this._host._afterLeavingCenter.subscribe(()=>{this._host.preserveContent||this._ngZone.run(()=>this.detach())})}ngOnDestroy(){super.ngOnDestroy(),this._centeringSub.unsubscribe(),this._leavingSub.unsubscribe()}static \u0275fac=function(e){return new(e||a)};static \u0275dir=M({type:a,selectors:[["","matTabBodyHost",""]],features:[A]})}return a})(),gt=(()=>{class a{_elementRef=b(L);_dir=b(bt,{optional:!0});_ngZone=b(F);_injector=b(et);_renderer=b(nt);_diAnimationsDisabled=J();_eventCleanups;_initialized=!1;_fallbackTimer;_positionIndex;_dirChangeSubscription=E.EMPTY;_position;_previousPosition;_onCentering=new T;_beforeCentering=new T;_afterLeavingCenter=new T;_onCentered=new T(!0);_portalHost;_contentElement;_content;animationDuration="500ms";preserveContent=!1;set position(t){this._positionIndex=t,this._computePositionAnimationState()}constructor(){if(this._dir){let t=b(Y);this._dirChangeSubscription=this._dir.change.subscribe(e=>{this._computePositionAnimationState(e),t.markForCheck()})}}ngOnInit(){this._bindTransitionEvents(),this._position==="center"&&(this._setActiveClass(!0),V(()=>this._onCentering.emit(this._elementRef.nativeElement.clientHeight),{injector:this._injector})),this._initialized=!0}ngOnDestroy(){clearTimeout(this._fallbackTimer),this._eventCleanups?.forEach(t=>t()),this._dirChangeSubscription.unsubscribe()}_bindTransitionEvents(){this._ngZone.runOutsideAngular(()=>{let t=this._elementRef.nativeElement,e=n=>{n.target===this._contentElement?.nativeElement&&(this._elementRef.nativeElement.classList.remove("mat-tab-body-animating"),n.type==="transitionend"&&this._transitionDone())};this._eventCleanups=[this._renderer.listen(t,"transitionstart",n=>{n.target===this._contentElement?.nativeElement&&(this._elementRef.nativeElement.classList.add("mat-tab-body-animating"),this._transitionStarted())}),this._renderer.listen(t,"transitionend",e),this._renderer.listen(t,"transitioncancel",e)]})}_transitionStarted(){clearTimeout(this._fallbackTimer);let t=this._position==="center";this._beforeCentering.emit(t),t&&this._onCentering.emit(this._elementRef.nativeElement.clientHeight)}_transitionDone(){this._position==="center"?this._onCentered.emit():this._previousPosition==="center"&&this._afterLeavingCenter.emit()}_setActiveClass(t){this._elementRef.nativeElement.classList.toggle("mat-mdc-tab-body-active",t)}_getLayoutDirection(){return this._dir&&this._dir.value==="rtl"?"rtl":"ltr"}_isCenterPosition(){return this._positionIndex===0}_computePositionAnimationState(t=this._getLayoutDirection()){this._previousPosition=this._position,this._positionIndex<0?this._position=t=="ltr"?"left":"right":this._positionIndex>0?this._position=t=="ltr"?"right":"left":this._position="center",this._animationsDisabled()?this._simulateTransitionEvents():this._initialized&&(this._position==="center"||this._previousPosition==="center")&&(clearTimeout(this._fallbackTimer),this._fallbackTimer=this._ngZone.runOutsideAngular(()=>setTimeout(()=>this._simulateTransitionEvents(),100)))}_simulateTransitionEvents(){this._transitionStarted(),V(()=>this._transitionDone(),{injector:this._injector})}_animationsDisabled(){return this._diAnimationsDisabled||this.animationDuration==="0ms"||this.animationDuration==="0s"}static \u0275fac=function(e){return new(e||a)};static \u0275cmp=D({type:a,selectors:[["mat-tab-body"]],viewQuery:function(e,n){if(e&1&&N(Ie,5)(ze,5),e&2){let i;u(i=h())&&(n._portalHost=i.first),u(i=h())&&(n._contentElement=i.first)}},hostAttrs:[1,"mat-mdc-tab-body"],hostVars:1,hostBindings:function(e,n){e&2&&I("inert",n._position==="center"?null:"")},inputs:{_content:[0,"content","_content"],animationDuration:"animationDuration",preserveContent:"preserveContent",position:"position"},outputs:{_onCentering:"_onCentering",_beforeCentering:"_beforeCentering",_onCentered:"_onCentered"},decls:3,vars:6,consts:[["content",""],["cdkScrollable","",1,"mat-mdc-tab-body-content"],["matTabBodyHost",""]],template:function(e,n){e&1&&(r(0,"div",1,0),p(2,Ge,0,0,"ng-template",2),o()),e&2&&C("mat-tab-body-content-left",n._position==="left")("mat-tab-body-content-right",n._position==="right")("mat-tab-body-content-can-animate",n._position==="center"||n._previousPosition==="center")},dependencies:[Ie,pe],styles:[`.mat-mdc-tab-body {
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  position: absolute;
  display: block;
  overflow: hidden;
  outline: 0;
  flex-basis: 100%;
}
.mat-mdc-tab-body.mat-mdc-tab-body-active {
  position: relative;
  overflow-x: hidden;
  overflow-y: auto;
  z-index: 1;
  flex-grow: 1;
}
.mat-mdc-tab-group.mat-mdc-tab-group-dynamic-height .mat-mdc-tab-body.mat-mdc-tab-body-active {
  overflow-y: hidden;
}

.mat-mdc-tab-body-content {
  height: 100%;
  overflow: auto;
  transform: none;
  visibility: hidden;
}
.mat-tab-body-animating > .mat-mdc-tab-body-content, .mat-mdc-tab-body-active > .mat-mdc-tab-body-content {
  visibility: visible;
}
.mat-tab-body-animating > .mat-mdc-tab-body-content {
  min-height: 1px;
}
.mat-mdc-tab-group-dynamic-height .mat-mdc-tab-body-content {
  overflow: hidden;
}

.mat-tab-body-content-can-animate {
  transition: transform var(--mat-tab-animation-duration) 1ms cubic-bezier(0.35, 0, 0.25, 1);
}
.mat-mdc-tab-body-wrapper._mat-animation-noopable .mat-tab-body-content-can-animate {
  transition: none;
}

.mat-tab-body-content-left {
  transform: translate3d(-100%, 0, 0);
}

.mat-tab-body-content-right {
  transform: translate3d(100%, 0, 0);
}
`],encapsulation:2})}return a})(),Me=(()=>{class a{_elementRef=b(L);_changeDetectorRef=b(Y);_ngZone=b(F);_tabsSubscription=E.EMPTY;_tabLabelSubscription=E.EMPTY;_tabBodySubscription=E.EMPTY;_diAnimationsDisabled=J();_allTabs;_tabBodies;_tabBodyWrapper;_tabHeader;_tabs=new Lt;_indexToSelect=0;_lastFocusedTabIndex=null;_tabBodyWrapperHeight=0;color;get fitInkBarToContent(){return this._fitInkBarToContent}set fitInkBarToContent(t){this._fitInkBarToContent=t,this._changeDetectorRef.markForCheck()}_fitInkBarToContent=!1;stretchTabs=!0;alignTabs=null;dynamicHeight=!1;get selectedIndex(){return this._selectedIndex}set selectedIndex(t){this._indexToSelect=isNaN(t)?null:t}_selectedIndex=null;headerPosition="above";get animationDuration(){return this._animationDuration}set animationDuration(t){let e=t+"";this._animationDuration=/^\d+$/.test(e)?t+"ms":e}_animationDuration;get contentTabIndex(){return this._contentTabIndex}set contentTabIndex(t){this._contentTabIndex=isNaN(t)?null:t}_contentTabIndex=null;disablePagination=!1;disableRipple=!1;preserveContent=!1;get backgroundColor(){return this._backgroundColor}set backgroundColor(t){let e=this._elementRef.nativeElement.classList;e.remove("mat-tabs-with-background",`mat-background-${this.backgroundColor}`),t&&e.add("mat-tabs-with-background",`mat-background-${t}`),this._backgroundColor=t}_backgroundColor;ariaLabel;ariaLabelledby;selectedIndexChange=new T;focusChange=new T;animationDone=new T;selectedTabChange=new T(!0);_groupId;_isServer=!b(pt).isBrowser;constructor(){let t=b(sn,{optional:!0});this._groupId=b(oe).getId("mat-tab-group-"),this.animationDuration=t&&t.animationDuration?t.animationDuration:"500ms",this.disablePagination=t&&t.disablePagination!=null?t.disablePagination:!1,this.dynamicHeight=t&&t.dynamicHeight!=null?t.dynamicHeight:!1,t?.contentTabIndex!=null&&(this.contentTabIndex=t.contentTabIndex),this.preserveContent=!!t?.preserveContent,this.fitInkBarToContent=t&&t.fitInkBarToContent!=null?t.fitInkBarToContent:!1,this.stretchTabs=t&&t.stretchTabs!=null?t.stretchTabs:!0,this.alignTabs=t&&t.alignTabs!=null?t.alignTabs:null}ngAfterContentChecked(){let t=this._indexToSelect=this._clampTabIndex(this._indexToSelect);if(this._selectedIndex!=t){let e=this._selectedIndex==null;if(!e){this.selectedTabChange.emit(this._createChangeEvent(t));let n=this._tabBodyWrapper.nativeElement;n.style.minHeight=n.clientHeight+"px"}Promise.resolve().then(()=>{this._tabs.forEach((n,i)=>n.isActive=i===t),e||(this.selectedIndexChange.emit(t),this._tabBodyWrapper.nativeElement.style.minHeight="")})}this._tabs.forEach((e,n)=>{e.position=n-t,this._selectedIndex!=null&&e.position==0&&!e.origin&&(e.origin=t-this._selectedIndex)}),this._selectedIndex!==t&&(this._selectedIndex=t,this._lastFocusedTabIndex=null,this._changeDetectorRef.markForCheck())}ngAfterContentInit(){this._subscribeToAllTabChanges(),this._subscribeToTabLabels(),this._tabsSubscription=this._tabs.changes.subscribe(()=>{let t=this._clampTabIndex(this._indexToSelect);if(t===this._selectedIndex){let e=this._tabs.toArray(),n;for(let i=0;i<e.length;i++)if(e[i].isActive){this._indexToSelect=this._selectedIndex=i,this._lastFocusedTabIndex=null,n=e[i];break}!n&&e[t]&&Promise.resolve().then(()=>{e[t].isActive=!0,this.selectedTabChange.emit(this._createChangeEvent(t))})}this._changeDetectorRef.markForCheck()})}ngAfterViewInit(){this._tabBodySubscription=this._tabBodies.changes.subscribe(()=>this._bodyCentered(!0))}_subscribeToAllTabChanges(){this._allTabs.changes.pipe(z(this._allTabs)).subscribe(t=>{this._tabs.reset(t.filter(e=>e._closestTabGroup===this||!e._closestTabGroup)),this._tabs.notifyOnChanges()})}ngOnDestroy(){this._tabs.destroy(),this._tabsSubscription.unsubscribe(),this._tabLabelSubscription.unsubscribe(),this._tabBodySubscription.unsubscribe()}realignInkBar(){this._tabHeader&&this._tabHeader._alignInkBarToSelectedTab()}updatePagination(){this._tabHeader&&this._tabHeader.updatePagination()}focusTab(t){let e=this._tabHeader;e&&(e.focusIndex=t)}_focusChanged(t){this._lastFocusedTabIndex=t,this.focusChange.emit(this._createChangeEvent(t))}_createChangeEvent(t){let e=new vt;return e.index=t,this._tabs&&this._tabs.length&&(e.tab=this._tabs.toArray()[t]),e}_subscribeToTabLabels(){this._tabLabelSubscription&&this._tabLabelSubscription.unsubscribe(),this._tabLabelSubscription=Q(...this._tabs.map(t=>t._stateChanges)).subscribe(()=>this._changeDetectorRef.markForCheck())}_clampTabIndex(t){return Math.min(this._tabs.length-1,Math.max(t||0,0))}_getTabLabelId(t,e){return t.id||`${this._groupId}-label-${e}`}_getTabContentId(t){return`${this._groupId}-content-${t}`}_setTabBodyWrapperHeight(t){if(!this.dynamicHeight||!this._tabBodyWrapperHeight){this._tabBodyWrapperHeight=t;return}let e=this._tabBodyWrapper.nativeElement;e.style.height=this._tabBodyWrapperHeight+"px",this._tabBodyWrapper.nativeElement.offsetHeight&&(e.style.height=t+"px")}_removeTabBodyWrapperHeight(){let t=this._tabBodyWrapper.nativeElement;this._tabBodyWrapperHeight=t.clientHeight,t.style.height="",this._ngZone.run(()=>this.animationDone.emit())}_handleClick(t,e,n){e.focusIndex=n,t.disabled||(this.selectedIndex=n)}_getTabIndex(t){let e=this._lastFocusedTabIndex??this.selectedIndex;return t===e?0:-1}_tabFocusChanged(t,e){t&&t!=="mouse"&&t!=="touch"&&(this._tabHeader.focusIndex=e)}_bodyCentered(t){t&&this._tabBodies?.forEach((e,n)=>e._setActiveClass(n===this._selectedIndex))}_animationsDisabled(){return this._diAnimationsDisabled||this.animationDuration==="0"||this.animationDuration==="0ms"}static \u0275fac=function(e){return new(e||a)};static \u0275cmp=D({type:a,selectors:[["mat-tab-group"]],contentQueries:function(e,n,i){if(e&1&&$(i,xt,5),e&2){let m;u(m=h())&&(n._allTabs=m)}},viewQuery:function(e,n){if(e&1&&N(Ve,5)(qe,5)(gt,5),e&2){let i;u(i=h())&&(n._tabBodyWrapper=i.first),u(i=h())&&(n._tabHeader=i.first),u(i=h())&&(n._tabBodies=i)}},hostAttrs:[1,"mat-mdc-tab-group"],hostVars:11,hostBindings:function(e,n){e&2&&(I("mat-align-tabs",n.alignTabs),Z("mat-"+(n.color||"primary")),Ht("--mat-tab-animation-duration",n.animationDuration),C("mat-mdc-tab-group-dynamic-height",n.dynamicHeight)("mat-mdc-tab-group-inverted-header",n.headerPosition==="below")("mat-mdc-tab-group-stretch-tabs",n.stretchTabs))},inputs:{color:"color",fitInkBarToContent:[2,"fitInkBarToContent","fitInkBarToContent",x],stretchTabs:[2,"mat-stretch-tabs","stretchTabs",x],alignTabs:[0,"mat-align-tabs","alignTabs"],dynamicHeight:[2,"dynamicHeight","dynamicHeight",x],selectedIndex:[2,"selectedIndex","selectedIndex",X],headerPosition:"headerPosition",animationDuration:"animationDuration",contentTabIndex:[2,"contentTabIndex","contentTabIndex",X],disablePagination:[2,"disablePagination","disablePagination",x],disableRipple:[2,"disableRipple","disableRipple",x],preserveContent:[2,"preserveContent","preserveContent",x],backgroundColor:"backgroundColor",ariaLabel:[0,"aria-label","ariaLabel"],ariaLabelledby:[0,"aria-labelledby","ariaLabelledby"]},outputs:{selectedIndexChange:"selectedIndexChange",focusChange:"focusChange",animationDone:"animationDone",selectedTabChange:"selectedTabChange"},exportAs:["matTabGroup"],features:[H([{provide:Ee,useExisting:a}])],ngContentSelectors:yt,decls:9,vars:8,consts:[["tabHeader",""],["tabBodyWrapper",""],["tabNode",""],[3,"indexFocused","selectFocusedIndex","selectedIndex","disableRipple","disablePagination","aria-label","aria-labelledby"],["role","tab","matTabLabelWrapper","","cdkMonitorElementFocus","",1,"mdc-tab","mat-mdc-tab","mat-focus-indicator",3,"id","mdc-tab--active","class","disabled","fitInkBarToContent"],[1,"mat-mdc-tab-body-wrapper"],["role","tabpanel",3,"id","class","content","position","animationDuration","preserveContent"],["role","tab","matTabLabelWrapper","","cdkMonitorElementFocus","",1,"mdc-tab","mat-mdc-tab","mat-focus-indicator",3,"click","cdkFocusChange","id","disabled","fitInkBarToContent"],[1,"mdc-tab__ripple"],["mat-ripple","",1,"mat-mdc-tab-ripple",3,"matRippleTrigger","matRippleDisabled"],[1,"mdc-tab__content"],[1,"mdc-tab__text-label"],[3,"cdkPortalOutlet"],["role","tabpanel",3,"_onCentered","_onCentering","_beforeCentering","id","content","position","animationDuration","preserveContent"]],template:function(e,n){e&1&&(W(),r(0,"mat-tab-header",3,0),y("indexFocused",function(m){return n._focusChanged(m)})("selectFocusedIndex",function(m){return n.selectedIndex=m}),ot(2,$e,8,17,"div",4,rt),o(),at(4,Ze,1,0),r(5,"div",5,1),ot(7,Ke,1,10,"mat-tab-body",6,rt),o()),e&2&&(c("selectedIndex",n.selectedIndex||0)("disableRipple",n.disableRipple)("disablePagination",n.disablePagination),Nt("aria-label",n.ariaLabel)("aria-labelledby",n.ariaLabelledby),l(2),st(n._tabs),l(2),it(n._isServer?4:-1),l(),C("_mat-animation-noopable",n._animationsDisabled()),l(2),st(n._tabs))},dependencies:[on,De,ee,ut,ht,gt],styles:[`.mdc-tab {
  min-width: 90px;
  padding: 0 24px;
  display: flex;
  flex: 1 0 auto;
  justify-content: center;
  box-sizing: border-box;
  border: none;
  outline: none;
  text-align: center;
  white-space: nowrap;
  cursor: pointer;
  z-index: 1;
  touch-action: manipulation;
}

.mdc-tab__content {
  display: flex;
  align-items: center;
  justify-content: center;
  height: inherit;
  pointer-events: none;
}

.mdc-tab__text-label {
  transition: 150ms color linear;
  display: inline-block;
  line-height: 1;
  z-index: 2;
}

.mdc-tab--active .mdc-tab__text-label {
  transition-delay: 100ms;
}

._mat-animation-noopable .mdc-tab__text-label {
  transition: none;
}

.mdc-tab-indicator {
  display: flex;
  position: absolute;
  top: 0;
  left: 0;
  justify-content: center;
  width: 100%;
  height: 100%;
  pointer-events: none;
  z-index: 1;
}

.mdc-tab-indicator__content {
  transition: var(--mat-tab-animation-duration, 250ms) transform cubic-bezier(0.4, 0, 0.2, 1);
  transform-origin: left;
  opacity: 0;
}

.mdc-tab-indicator__content--underline {
  align-self: flex-end;
  box-sizing: border-box;
  width: 100%;
  border-top-style: solid;
}

.mdc-tab-indicator--active .mdc-tab-indicator__content {
  opacity: 1;
}

._mat-animation-noopable .mdc-tab-indicator__content, .mdc-tab-indicator--no-transition .mdc-tab-indicator__content {
  transition: none;
}

.mat-mdc-tab-ripple.mat-mdc-tab-ripple {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  pointer-events: none;
}

.mat-mdc-tab {
  -webkit-tap-highlight-color: transparent;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-decoration: none;
  background: none;
  height: var(--mat-tab-container-height, 48px);
  font-family: var(--mat-tab-label-text-font, var(--mat-sys-title-small-font));
  font-size: var(--mat-tab-label-text-size, var(--mat-sys-title-small-size));
  letter-spacing: var(--mat-tab-label-text-tracking, var(--mat-sys-title-small-tracking));
  line-height: var(--mat-tab-label-text-line-height, var(--mat-sys-title-small-line-height));
  font-weight: var(--mat-tab-label-text-weight, var(--mat-sys-title-small-weight));
}
.mat-mdc-tab.mdc-tab {
  flex-grow: 0;
}
.mat-mdc-tab .mdc-tab-indicator__content--underline {
  border-color: var(--mat-tab-active-indicator-color, var(--mat-sys-primary));
  border-top-width: var(--mat-tab-active-indicator-height, 2px);
  border-radius: var(--mat-tab-active-indicator-shape, 0);
}
.mat-mdc-tab:hover .mdc-tab__text-label {
  color: var(--mat-tab-inactive-hover-label-text-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab:focus .mdc-tab__text-label {
  color: var(--mat-tab-inactive-focus-label-text-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab.mdc-tab--active .mdc-tab__text-label {
  color: var(--mat-tab-active-label-text-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab.mdc-tab--active .mdc-tab__ripple::before,
.mat-mdc-tab.mdc-tab--active .mat-ripple-element {
  background-color: var(--mat-tab-active-ripple-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab.mdc-tab--active:hover .mdc-tab__text-label {
  color: var(--mat-tab-active-hover-label-text-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab.mdc-tab--active:hover .mdc-tab-indicator__content--underline {
  border-color: var(--mat-tab-active-hover-indicator-color, var(--mat-sys-primary));
}
.mat-mdc-tab.mdc-tab--active:focus .mdc-tab__text-label {
  color: var(--mat-tab-active-focus-label-text-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab.mdc-tab--active:focus .mdc-tab-indicator__content--underline {
  border-color: var(--mat-tab-active-focus-indicator-color, var(--mat-sys-primary));
}
.mat-mdc-tab.mat-mdc-tab-disabled {
  opacity: 0.4;
  pointer-events: none;
}
.mat-mdc-tab.mat-mdc-tab-disabled .mdc-tab__content {
  pointer-events: none;
}
.mat-mdc-tab.mat-mdc-tab-disabled .mdc-tab__ripple::before,
.mat-mdc-tab.mat-mdc-tab-disabled .mat-ripple-element {
  background-color: var(--mat-tab-disabled-ripple-color, var(--mat-sys-on-surface-variant));
}
.mat-mdc-tab .mdc-tab__ripple::before {
  content: "";
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  opacity: 0;
  pointer-events: none;
  background-color: var(--mat-tab-inactive-ripple-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab .mdc-tab__text-label {
  color: var(--mat-tab-inactive-label-text-color, var(--mat-sys-on-surface));
  display: inline-flex;
  align-items: center;
}
.mat-mdc-tab .mdc-tab__content {
  position: relative;
  pointer-events: auto;
}
.mat-mdc-tab:hover .mdc-tab__ripple::before {
  opacity: 0.04;
}
.mat-mdc-tab.cdk-program-focused .mdc-tab__ripple::before, .mat-mdc-tab.cdk-keyboard-focused .mdc-tab__ripple::before {
  opacity: 0.12;
}
.mat-mdc-tab .mat-ripple-element {
  opacity: 0.12;
  background-color: var(--mat-tab-inactive-ripple-color, var(--mat-sys-on-surface));
}
.mat-mdc-tab-group.mat-mdc-tab-group-stretch-tabs > .mat-mdc-tab-header .mat-mdc-tab {
  flex-grow: 1;
}

.mat-mdc-tab-group {
  display: flex;
  flex-direction: column;
  max-width: 100%;
}
.mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header, .mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header-pagination {
  background-color: var(--mat-tab-background-color);
}
.mat-mdc-tab-group.mat-tabs-with-background.mat-primary > .mat-mdc-tab-header .mat-mdc-tab .mdc-tab__text-label {
  color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-tabs-with-background.mat-primary > .mat-mdc-tab-header .mdc-tab-indicator__content--underline {
  border-color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-tabs-with-background:not(.mat-primary) > .mat-mdc-tab-header .mat-mdc-tab:not(.mdc-tab--active) .mdc-tab__text-label {
  color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-tabs-with-background:not(.mat-primary) > .mat-mdc-tab-header .mat-mdc-tab:not(.mdc-tab--active) .mdc-tab-indicator__content--underline {
  border-color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header .mat-mdc-tab-header-pagination-chevron,
.mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header .mat-focus-indicator::before, .mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header-pagination .mat-mdc-tab-header-pagination-chevron,
.mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header-pagination .mat-focus-indicator::before {
  border-color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header .mat-ripple-element, .mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header .mdc-tab__ripple::before, .mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header-pagination .mat-ripple-element, .mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header-pagination .mdc-tab__ripple::before {
  background-color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header .mat-mdc-tab-header-pagination-chevron, .mat-mdc-tab-group.mat-tabs-with-background > .mat-mdc-tab-header-pagination .mat-mdc-tab-header-pagination-chevron {
  color: var(--mat-tab-foreground-color);
}
.mat-mdc-tab-group.mat-mdc-tab-group-inverted-header {
  flex-direction: column-reverse;
}
.mat-mdc-tab-group.mat-mdc-tab-group-inverted-header .mdc-tab-indicator__content--underline {
  align-self: flex-start;
}

.mat-mdc-tab-body-wrapper {
  position: relative;
  overflow: hidden;
  display: flex;
  transition: height 500ms cubic-bezier(0.35, 0, 0.25, 1);
}
.mat-mdc-tab-body-wrapper._mat-animation-noopable {
  transition: none !important;
  animation: none !important;
}
`],encapsulation:2})}return a})(),vt=class{index;tab};var Se=(()=>{class a{static \u0275fac=function(e){return new(e||a)};static \u0275mod=Ft({type:a});static \u0275inj=Rt({imports:[Jt]})}return a})();var dn=(a,s)=>({background:a,color:s});function cn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function mn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function bn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function pn(a,s){a&1&&(r(0,"span"),d(1,"Convert"),o())}function un(a,s){a&1&&v(0,"mat-spinner",43)}function hn(a,s){if(a&1&&(r(0,"div",44)(1,"p",45),d(2,"Conversion Result"),o(),r(3,"h2",46),d(4),ct(5,"number"),r(6,"span",47),d(7),o()()()),a&2){let t=g();l(4),K(" ",mt(5,2,t.convertResult.value,"1.2-4")," "),l(3),f(t.convertResult.unit)}}function _n(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function fn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function gn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function vn(a,s){a&1&&(r(0,"span"),d(1,"Compare Quantities"),o())}function yn(a,s){a&1&&v(0,"mat-spinner",43)}function xn(a,s){if(a&1&&(r(0,"div",48)(1,"mat-icon",49),d(2),o(),r(3,"span",50),d(4),o()()),a&2){let t=g();c("ngStyle",Ot(3,dn,t.compareResult?"rgba(76, 175, 80, 0.1)":"rgba(244, 67, 54, 0.1)",t.compareResult?"#4CAF50":"#F44336")),l(2),f(t.compareResult?"check_circle":"cancel"),l(2),K(" The quantities are ",t.compareResult?"EQUAL":"NOT EQUAL"," ")}}function Tn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function Cn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function kn(a,s){if(a&1&&(r(0,"mat-option",42),d(1),o()),a&2){let t=s.$implicit;c("value",t),l(),f(t)}}function In(a,s){a&1&&(r(0,"span"),d(1,"Calculate"),o())}function wn(a,s){a&1&&v(0,"mat-spinner",43)}function En(a,s){if(a&1&&(r(0,"div",51)(1,"p",45),d(2,"Calculated Value"),o(),r(3,"h2",52),d(4),ct(5,"number"),r(6,"span",47),d(7),o()()()),a&2){let t=g();l(4),K(" ",mt(5,2,t.arithmeticResult.value,"1.2-4")," "),l(3),f(t.arithmeticResult.unit)}}var Re=class a{constructor(s,t,e){this.fb=s;this.http=t;this.snackBar=e;this.convertForm=this.fb.group({measurementType:["LENGTH",_.required],value:[null,_.required],fromUnit:["",_.required],toUnit:["",_.required]}),this.compareForm=this.fb.group({measurementType:["LENGTH",_.required],value1:[null,_.required],unit1:["",_.required],value2:[null,_.required],unit2:["",_.required]}),this.arithmeticForm=this.fb.group({measurementType:["LENGTH",_.required],operation:["add",_.required],value1:[null,_.required],unit1:["",_.required],value2:[null,_.required],unit2:["",_.required]}),this.convertUnits=this.unitsMap.LENGTH,this.compareUnits=this.unitsMap.LENGTH,this.arithmeticUnits=this.unitsMap.LENGTH,this.convertForm.get("measurementType")?.valueChanges.subscribe(n=>{this.convertUnits=this.unitsMap[n],this.convertForm.patchValue({fromUnit:"",toUnit:""}),this.convertResult=null}),this.compareForm.get("measurementType")?.valueChanges.subscribe(n=>{this.compareUnits=this.unitsMap[n],this.compareForm.patchValue({unit1:"",unit2:""}),this.compareResult=null}),this.arithmeticForm.get("measurementType")?.valueChanges.subscribe(n=>{this.arithmeticUnits=this.unitsMap[n],this.arithmeticForm.patchValue({unit1:"",unit2:""}),this.arithmeticResult=null})}convertForm;compareForm;arithmeticForm;measurementTypes=["LENGTH","WEIGHT","VOLUME","TEMPERATURE"];unitsMap={LENGTH:["INCHES","FEET","YARDS","CENTIMETERS","METERS"],WEIGHT:["GRAM","KILOGRAM","POUND","OUNCE"],VOLUME:["GALLON","LITER","MILLILITER"],TEMPERATURE:["CELSIUS","FAHRENHEIT","KELVIN"]};convertUnits=[];compareUnits=[];arithmeticUnits=[];convertResult=null;compareResult=null;arithmeticResult=null;loading=!1;doConvert(){if(this.convertForm.invalid)return;this.loading=!0;let s={quantity:{value:this.convertForm.value.value,unit:this.convertForm.value.fromUnit,measurementType:this.convertForm.value.measurementType},targetUnit:this.convertForm.value.toUnit};this.http.post("http://54.206.167.226:8080/api/quantity/convert",s).subscribe({next:t=>{this.loading=!1,this.convertResult=t},error:t=>{this.loading=!1,this.snackBar.open(t.error?.message||"Conversion failed","Close",{duration:5e3})}})}doCompare(){if(this.compareForm.invalid)return;this.loading=!0;let s={q1:{value:this.compareForm.value.value1,unit:this.compareForm.value.unit1,measurementType:this.compareForm.value.measurementType},q2:{value:this.compareForm.value.value2,unit:this.compareForm.value.unit2,measurementType:this.compareForm.value.measurementType}};this.http.post("http://54.206.167.226:8080/api/quantity/compare",s).subscribe({next:t=>{this.loading=!1,this.compareResult=t},error:t=>{this.loading=!1,this.snackBar.open(t.error?.message||"Comparison failed","Close",{duration:5e3})}})}doArithmetic(){if(this.arithmeticForm.invalid)return;this.loading=!0;let s={q1:{value:this.arithmeticForm.value.value1,unit:this.arithmeticForm.value.unit1,measurementType:this.arithmeticForm.value.measurementType},q2:{value:this.arithmeticForm.value.value2,unit:this.arithmeticForm.value.unit2,measurementType:this.arithmeticForm.value.measurementType}},t=this.arithmeticForm.value.operation;this.http.post(`http://54.206.167.226:8080/api/quantity/${t}`,s).subscribe({next:e=>{this.loading=!1,this.arithmeticResult=e},error:e=>{this.loading=!1,this.snackBar.open(e.error?.message||"Arithmetic operation failed","Close",{duration:5e3})}})}static \u0275fac=function(t){return new(t||a)(j(Xt),j(qt),j(ye))};static \u0275cmp=D({type:a,selectors:[["app-quantity"]],decls:120,vars:24,consts:[[2,"max-width","800px","margin","0 auto"],[2,"font-weight","500","margin-bottom","20px"],[2,"border-radius","16px"],["animationDuration","0ms",1,"p-3"],["label","Convert"],[2,"padding","30px 20px"],[3,"ngSubmit","formGroup"],["appearance","outline",2,"width","100%","margin-bottom","15px"],["formControlName","measurementType"],[3,"value",4,"ngFor","ngForOf"],[2,"display","flex","gap","15px","flex-wrap","wrap"],["appearance","outline",2,"flex","1","min-width","200px"],["matInput","","type","number","formControlName","value"],["formControlName","fromUnit"],[2,"display","flex","align-items","center","justify-content","center","padding","0 10px"],["color","primary",2,"font-size","32px","height","32px","width","32px","opacity","0.6"],["formControlName","toUnit"],["mat-flat-button","","color","primary","type","submit",2,"width","100%","padding","24px","font-size","16px","margin-top","20px",3,"disabled"],[4,"ngIf"],["diameter","20","style","margin: 0 auto;",4,"ngIf"],["style","margin-top: 30px; text-align: center; padding: 20px; background: rgba(79,70,229,0.05); border-radius: 12px; border: 1px bordered var(--border);",4,"ngIf"],["label","Compare"],[2,"display","flex","gap","20px","flex-direction","column"],[2,"display","flex","gap","15px","align-items","center","padding","15px","border","1px solid var(--border)","border-radius","8px"],[2,"flex-shrink","0","font-weight","bold","width","30px"],["appearance","outline",2,"flex","1","margin-bottom","-1.25em"],["matInput","","type","number","formControlName","value1"],["formControlName","unit1"],["matInput","","type","number","formControlName","value2"],["formControlName","unit2"],["mat-flat-button","","color","accent","type","submit",2,"width","100%","padding","24px","font-size","16px","margin-top","20px",3,"disabled"],["style","margin-top: 30px; text-align: center; padding: 20px; border-radius: 12px; font-size: 20px;",3,"ngStyle",4,"ngIf"],["label","Arithmetic"],[2,"display","flex","gap","15px"],["appearance","outline",2,"flex","2","margin-bottom","15px"],["appearance","outline",2,"flex","1","margin-bottom","15px"],["formControlName","operation"],["value","add"],["value","subtract"],["value","divide"],["mat-flat-button","","color","primary","type","submit",2,"width","100%","padding","24px","font-size","16px","margin-top","20px","background","#10b981",3,"disabled"],["style","margin-top: 30px; text-align: center; padding: 20px; background: rgba(16, 185, 129, 0.1); border-radius: 12px; border: 1px bordered #10b981;",4,"ngIf"],[3,"value"],["diameter","20",2,"margin","0 auto"],[2,"margin-top","30px","text-align","center","padding","20px","background","rgba(79,70,229,0.05)","border-radius","12px","border","1px bordered var(--border)"],[2,"color","var(--text-secondary)","margin","0"],[2,"font-size","32px","color","var(--primary)","margin","10px 0 0"],[2,"font-size","20px","opacity","0.7"],[2,"margin-top","30px","text-align","center","padding","20px","border-radius","12px","font-size","20px",3,"ngStyle"],[2,"vertical-align","middle","margin-right","8px"],[2,"vertical-align","middle","font-weight","500"],[2,"margin-top","30px","text-align","center","padding","20px","background","rgba(16, 185, 129, 0.1)","border-radius","12px","border","1px bordered #10b981"],[2,"font-size","32px","color","#10b981","margin","10px 0 0"]],template:function(t,e){t&1&&(r(0,"div",0)(1,"h1",1),d(2,"Measure & Calculate"),o(),r(3,"mat-card",2)(4,"mat-tab-group",3)(5,"mat-tab",4)(6,"div",5)(7,"form",6),y("ngSubmit",function(){return e.doConvert()}),r(8,"mat-form-field",7)(9,"mat-label"),d(10,"Measurement Type"),o(),r(11,"mat-select",8),p(12,cn,2,2,"mat-option",9),o()(),r(13,"div",10)(14,"mat-form-field",11)(15,"mat-label"),d(16,"Value"),o(),v(17,"input",12),o(),r(18,"mat-form-field",11)(19,"mat-label"),d(20,"From Unit"),o(),r(21,"mat-select",13),p(22,mn,2,2,"mat-option",9),o()(),r(23,"div",14)(24,"mat-icon",15),d(25,"arrow_forward"),o()(),r(26,"mat-form-field",11)(27,"mat-label"),d(28,"To Unit"),o(),r(29,"mat-select",16),p(30,bn,2,2,"mat-option",9),o()()(),r(31,"button",17),p(32,pn,2,0,"span",18)(33,un,1,0,"mat-spinner",19),o()(),p(34,hn,8,5,"div",20),o()(),r(35,"mat-tab",21)(36,"div",5)(37,"form",6),y("ngSubmit",function(){return e.doCompare()}),r(38,"mat-form-field",7)(39,"mat-label"),d(40,"Measurement Type"),o(),r(41,"mat-select",8),p(42,_n,2,2,"mat-option",9),o()(),r(43,"div",22)(44,"div",23)(45,"div",24),d(46,"Q1"),o(),r(47,"mat-form-field",25)(48,"mat-label"),d(49,"Value"),o(),v(50,"input",26),o(),r(51,"mat-form-field",25)(52,"mat-label"),d(53,"Unit"),o(),r(54,"mat-select",27),p(55,fn,2,2,"mat-option",9),o()()(),r(56,"div",23)(57,"div",24),d(58,"Q2"),o(),r(59,"mat-form-field",25)(60,"mat-label"),d(61,"Value"),o(),v(62,"input",28),o(),r(63,"mat-form-field",25)(64,"mat-label"),d(65,"Unit"),o(),r(66,"mat-select",29),p(67,gn,2,2,"mat-option",9),o()()()(),r(68,"button",30),p(69,vn,2,0,"span",18)(70,yn,1,0,"mat-spinner",19),o()(),p(71,xn,5,6,"div",31),o()(),r(72,"mat-tab",32)(73,"div",5)(74,"form",6),y("ngSubmit",function(){return e.doArithmetic()}),r(75,"div",33)(76,"mat-form-field",34)(77,"mat-label"),d(78,"Measurement Type"),o(),r(79,"mat-select",8),p(80,Tn,2,2,"mat-option",9),o()(),r(81,"mat-form-field",35)(82,"mat-label"),d(83,"Operation"),o(),r(84,"mat-select",36)(85,"mat-option",37),d(86,"Add"),o(),r(87,"mat-option",38),d(88,"Subtract"),o(),r(89,"mat-option",39),d(90,"Divide"),o()()()(),r(91,"div",22)(92,"div",23)(93,"div",24),d(94,"Q1"),o(),r(95,"mat-form-field",25)(96,"mat-label"),d(97,"Value"),o(),v(98,"input",26),o(),r(99,"mat-form-field",25)(100,"mat-label"),d(101,"Unit"),o(),r(102,"mat-select",27),p(103,Cn,2,2,"mat-option",9),o()()(),r(104,"div",23)(105,"div",24),d(106,"Q2"),o(),r(107,"mat-form-field",25)(108,"mat-label"),d(109,"Value"),o(),v(110,"input",28),o(),r(111,"mat-form-field",25)(112,"mat-label"),d(113,"Unit"),o(),r(114,"mat-select",29),p(115,kn,2,2,"mat-option",9),o()()()(),r(116,"button",40),p(117,In,2,0,"span",18)(118,wn,1,0,"mat-spinner",19),o()(),p(119,En,8,5,"div",41),o()()()()()),t&2&&(l(7),c("formGroup",e.convertForm),l(5),c("ngForOf",e.measurementTypes),l(10),c("ngForOf",e.convertUnits),l(8),c("ngForOf",e.convertUnits),l(),c("disabled",e.convertForm.invalid||e.loading),l(),c("ngIf",!e.loading),l(),c("ngIf",e.loading),l(),c("ngIf",e.convertResult),l(3),c("formGroup",e.compareForm),l(5),c("ngForOf",e.measurementTypes),l(13),c("ngForOf",e.compareUnits),l(12),c("ngForOf",e.compareUnits),l(),c("disabled",e.compareForm.invalid||e.loading),l(),c("ngIf",!e.loading),l(),c("ngIf",e.loading),l(),c("ngIf",e.compareResult!==null),l(3),c("formGroup",e.arithmeticForm),l(6),c("ngForOf",e.measurementTypes),l(23),c("ngForOf",e.arithmeticUnits),l(12),c("ngForOf",e.arithmeticUnits),l(),c("disabled",e.arithmeticForm.invalid||e.loading),l(),c("ngIf",!e.loading),l(),c("ngIf",e.loading),l(),c("ngIf",e.arithmeticResult))},dependencies:[Te,Qt,zt,Gt,$t,jt,Zt,Wt,Ut,Yt,Kt,te,le,be,me,ce,ge,fe,ve,xe,Se,xt,Me,Vt],encapsulation:2})};export{Re as QuantityComponent};
