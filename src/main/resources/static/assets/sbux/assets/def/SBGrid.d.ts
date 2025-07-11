// tslint:disable-next-line:no-namespace
declare namespace _SBGrid {

    let CT, CSS, DEF, ST, UT, VER, $;

    function create(attribute: gridProperties): instance;
    function destroy(gridId?: string): void;
    function destroyAll(): void;
    function getGrid(gridId: string): instance;
    function getGrids(): string[];
    function getLastFocusGrid(): string;
    function getVersion(): string;

    interface comboFilterInColumnTypeinfo {
        usemode?: boolean;
        uppercol?: number;
        attrname?: string;
    }

    interface inputMaskInColumnTypeinfo {
        alias?: number;
        unmaskvalue?: boolean;
    }

    interface typeinfoInColumnProperties {
        // button type
        buttonvalue?: number;
        callback?: string | Function;

        // checbkox type
        checkedvalue?: string;
        uncheckedvalue?: string;

        // combo
        ref?: string;
        label?: string;
        value?: string;
        oneclickedit?: boolean;
        itemcount?: number;
        displayui?: boolean;
        position?: string;
        filtering?: comboFilterInColumnTypeinfo;

        // datepicker
        dateformat?: string;
        // oneclickedit? : boolean;
        locale?: string;
        clearbutton?: boolean;
        multiple?: number;
        // position? : string;
        // displayui? : boolean;
        calendartype?: string;
        yearrange?: number;

        // image
        imageuri?: string;
        imagewidth?: string;
        imageheight?: string;
        imagestyle?: string;
        imagealt?: string;
        imageclick?: string;
        imageerroruri?: string;

        // input
        maxlength?: number;
        autonext?: boolean;
        // oneclickedit? : boolean;
        mask?: inputMaskInColumnTypeinfo;
        autocomplete?: string[];

        // inputbutton
        // maxlength? : number;
        // oneclickedit? : boolean;
        // callback? : string|Function;
        // autocomplete? : string[];

        // inpubcombo
        // ref? : string;
        // label? : string;
        // value?: string;
        // oneclickedit?: boolean;
        // itemcount? : number;
        // displayui? : boolean;
        // position? : string;

        // inputdate
        // dateformat : string;
        // oneclickedit?: boolean;
        // locale? : string;
        // clearbutton? : boolean;
        // multiple? : number;
        // position? : string;
        alias?: string;
        // calendartype? : string;
        // yearrange? : number;

        // multiradio
        radiolabel?: string[];
        radiovalue?: string[];

        // outputbutton
        // callback? : string|Function;

        // radio
        // checkedvalue? : string;
        // uncheckedvalue? : string;

        // spinner
        max?: number;
        min?: number;
        step?: number;
        // oneclickedit?: boolean;
        // mask? : inputMaskInColumnTypeinfo;

    }

    interface filterInColumnProperties {
        usemode?: boolean;
        uitype?: string;
        displayui?: boolean;
    }

    interface calcInColumnProperties {
        gridId?: object;
        rowIndex?: number;
        columnIndex?: number;
    }

    interface formatInColumnProperties {
        type: string;
        rule: string;
        origin?: string;
        locale?: string;
        usetime?: boolean;
        callback?: string | Function;
    }

    interface roundInColumnProperties {
        type: string;
        position: number;
    }

    interface columnProperties {
        caption: string[] | string;
        ref: string;
        width?: string;
        style?: string;
        type?: string;

        typeinfo?: typeinfoInColumnProperties;

        calc?: string | calcInColumnProperties;
        columngroup?: object;
        columnhint?: string;

        datatype?: string;
        disabled?: boolean;

        filtering?: filterInColumnProperties;
        fixedstyle?: string;
        format?: formatInColumnProperties;

        hidden?: boolean;

        merge?: boolean;

        renderer?: Function;
        fixedRenderer?: Function;

        round?: roundInColumnProperties;

        skipkeyfocus?: boolean;
        skippaste?: boolean;
        sortable?: boolean;
    }

    interface finddataProperites {
        casesense?: boolean;
        fullmatch?: boolean;
        label?: string;
    }

    interface pageProperites {
        type: string;
        count: number;
        size: number;
        sorttype?: string;
        showgoalpageui?: boolean;
    }

    interface totalProperites {
        type?: string;
        position?: string;
        columns?: object;
        subtotalrow?: object;
        grandtotalrow?: object;
        datasorting?: boolean;
    }

    interface gridProperties {
        parentid: string;
        id: string;
        jsonref: string | any | any[];
        columns: any | columnProperties[];

        allowcopy?: boolean;
        allowpaste?: boolean;
        allowselection?: boolean;
        allowuserresize?: boolean;
        alternatecycle?: number;

        backcoloralternate?: string;

        datamergefalseskip?: boolean;
        datareplace?: string;
        disabled?: boolean;

        ellipsis?: boolean;
        emptycellonpaste?: boolean;
        emptyrecords?: string;
        emptyrecordsfontstyle?: string;
        explorerbar?: string;
        extendcol?: number;
        extendlastcol?: string;

        filtering?: boolean;
        finddata?: finddataProperites[];
        fixedrowheight?: string;
        frozenbottomrows?: number;
        frozencols?: number;
        frozenrows?: number;

        headermark?: boolean;
        height?: string;
        hiddencopynpaste?: boolean;

        locale?: boolean;

        mergecells?: string;
        mergecellsfixedrows?: string;

        oneclickedit?: boolean;

        paging?: pageProperites;
        pasteaddrow?: boolean;

        // personalize
        autosavepsnldata?: boolean;
        psnldataid?: string;

        removewhitespace?: boolean;
        resizinginterval?: number;
        rowdatatype?: string;
        rowdragmove?: boolean;
        rowheader?: string | string[];
        rowheaderbackcoloralternate?: string;
        rowheadercaption?: object;
        rowheaderwidth?: object;
        rowheight?: string;

        scrollbubbling?: boolean;
        selectmode?: string;
        showselectedcellsinfo?: string;
        showtotalrows?: boolean;

        tooltip?: boolean;
        tooltiptype?: string;
        total?: totalProperites;

        usemultisorting?: boolean;

        waitingui?: boolean;
        whitespacemerge?: boolean;
        width?: string;
    }

    interface instance {
        bind(eventName: string, functionName: any): void;

        addColumn(property: object): void;
        addRow(refresh?: boolean, addData?: any, afterMovesSroll?: boolean): void;
        addRows(addData: object[]): void;
        addStatus(rowIndex: number, status: number | string): void;

        clearExtendCol(): void;
        clearFilters(): void;
        clearMerge(): void;
        clearSelection(): void;
        clearStatus(): void;
        clickCell(rowIndex?: number, columnIndex?: number): void;
        clickRow(rowIndex: number, moveScroll: number): void;

        deleteColumn(columnIndex: number): void;
        deleteRow(rowIndex: number): void;
        deselectCell(rowIndex: number, columnIndex: number): void;
        deselectCells(startRowIndex: number, startColumnIndex: number, finishRowIndex: number, finishColumnIndex: number): void;
        deselectRow(rowIndex: number): void;
        dispatch(functionName: string): void;

        editCell(): void;

        findCell(searchValue: string, firstRowIndex: number, firstColumnIndex?: number, casesense?: boolean, matchAllOrPart?: boolean, compareTarget?: boolean): void;

        getBackColorAlternate();
        getCaption(returnType: string);
        getCellData(rowIndex: number, columnIndex: number);
        getCellDisabled(rowIndex: number, columnIndex: number);
        getCellLabelData(rowIndex: number, columnIndex: number);
        getCellStyle(rowIndex: number, columnIndex: number);
        getCellTooltip(rowIndex: number, columnIndex: number);
        getCheckedRowData(columnIndex: number);
        getCheckedRows(columnIndex: number);
        getClipBoardData();
        getCol();
        getColDisabled(columnIndex: number);
        getColHidden(columnIndex: number);
        getColID(columnIndex: number);
        getColList(condition: string, searchValue: string);
        getColOfID(columnId: string);
        getColRef(refereceName: string);
        getCols();
        getColSkipPaste(columnIndex: number);
        getColStatus(columnIndex: number);
        getColStyle(columnIndex: number, styleRange: string, returnStyleName: string);
        getColStyleEx(columnIndex: number, styleRange: string): object;
        getColType(columnIndex: number);
        getColumnFormat(columnIndex: number);
        getColumnGroup(columnIndex: number);
        getColumnHint(columnIndex: number);
        getColumnTypeInfo(columnIndex: number);
        getColUserAttr(columnIndex: number);
        getColWidth(columnIndex: number);
        getDataRowHeight();
        getEmptyCellOnPaste();
        getExplorerBar();
        getExtendCol();
        getExtendLastCol();
        getFixedCellcheckboxChecked(rowIndexOfAllCheckeBox: number, columnIndexOfAllCheckeBox: number);
        getFixedRows();
        getFrozenBottomRows();
        getFrozenCols();
        getFrozenRows();
        getGridDataAll(deepCopy: boolean);
        getGridStatus(returnStatusType?: string, customStatusName?: string, customRowName?: string);
        getGridStatusAll(customStatusName?: string, customRowName?: string);
        getHiddenCopyNPaste();
        getLastFocusRow();
        getMergeCells();
        getMergeCellsFixedRows();
        getMergeCol(columnIndex: number);
        getMouseCol();
        getMouseRow();
        getPagingInfo();
        getPrevCellDataInfo();
        getPrevCol();
        getPrevRow();
        getRefOfCol(columnIndex: number);
        getRow();
        getRowData(rowIndex: number, deepCopy?: boolean);
        getRowHeader();
        getRows();
        getRowStatus(rowIndex: number);
        getRowStyle(rowIndex: number, styleRange: string, returnStyleName: string);
        getRowStyleEx(rowIndex: number, styleRange: string);
        getSelectedCellsInfo();
        getSelectedCols();
        getSelectedRows();
        getSelectionMode();
        getShowSelectedCellsInfo();
        getShowTotalRows();
        getSortable(rowIndex: number);
        getTotalRowIndex();
        getUpdateData(returnJson?: boolean, returnStatusType?: string, customStatusName?: string, customRowName?: string);

        hide();

        initFiltering();
        initLocale(localeCode: string);
        insertColumn(rowIndex: number, rowAttribute: columnProperties);
        insertRow(columnIndex: number, position: string, data?: string | string[] | object, moveScroll?: boolean);
        isEditing();
        isHorizontalScroll();
        isMerge(rowIndex: number, columIndex: number);
        isRowHeader();
        isTotalRow(rowIndex: number);
        isVerticalScroll();

        lockGrid(showLoadingImage: boolean);

        moveColumn(targetColumnIndex: number, movingColumnIndex: number);
        movePaging(movingPageIndex: number);
        moveRow(targetRowIndex: number, movingRowIndex: number);
        moveScrollBottom(rowIndex: number, focusAfterMoving: boolean);
        moveScrollLeft(rowIndex: number, focusAfterMoving: boolean);
        moveScrollRight(rowIndex: number, focusAfterMoving: boolean);
        moveScrollTop(rowIndex: number, focusAfterMoving: boolean);
        multiSorting(columnsInfo: object[]);
        multiSortingIcon();

        savePersonalInfo(personalId: string);
        loadPersonalInfo(personalId: string);

        rebuild();
        refresh(refreshObject: object);
        removeCellStyle(rowIndex: number, columnIndex: number);
        removeCellStyles(startRowIndex: number, startColumnIndex: number, finishRowIndex: number, finishColumnIndex: number): void;
        removeColStyle(columnIndex: number, styleRange: string);
        removeColStyles(columnIndex: number | number[], styleRange: string);
        removeColumn();
        removeMultiSorting();
        removeRow(refresh?: boolean);
        removeRowStatus(rowIndex: number);
        removeRowStyle(rowIndex: number, styleRange: string);
        removeRowStyles(rowIndex: number | number[], styleRange: string);
        removeSorting();
        removeStatus(rowIndex: number, status: string);
        resize();

        searchFilteredRows(fiteringInfo: object[], operator: object[]);
        searchRows(columnIndex: number, searchValue: string, initIndex?: boolean);
        selectCell(rowIndex: number, columnIndex: number);
        selectCells(startRowIndex: number, startColumnIndex: number, finishRowIndex: number, finishColumnIndex: number);
        selectRadio(rowIndex: number, columnIndex: number);
        selectRow(rowIndex: number);
        selectRows(rowIndex: number[]);
        setAutoComplete(columIndex: number, data: string[]);
        setBackColorAlternate(colorValue: string);
        setCaption(captionInfo: string | string[]);
        setCellData(rowIndex: number, columnIndex: number, data: string, refresh?: boolean, changeStauts?: boolean);
        setCellDisabled(startRowIndex: number, startColumnIndex: number, finishRowIndex: number, finishColumnIndex: number, disabled: boolean, refresh?: boolean);
        setCellHide(rowIndex: number, columnIndex: number, isHide: boolean);
        setCellStyle(styleName: string, startRowIndex: number, startColumnIndex: number, finishRowIndex: number, finishColumnIndex: number, styleValue: string, refresh?: boolean);
        setCellStyleEx(rowIndex: number, columnIndex: number, style: string, refresh?: boolean);
        setCellStyles(startRowIndex: number, startColumnIndex: number, finishRowIndex: number, finishColumnIndex: number, style: string, refresh?: boolean);
        setCellTooltip(rowIndex: number, columnIndex: number, tooltip: string);
        setClipBoardData(changingData: string);
        setCol(columIndex: number);
        setColDisabled(columIndex: number, disabled: boolean, refresh?: boolean);
        setColHidden(columIndex: number, hidden: boolean, merge?: boolean);
        setColSkipPaste(columIndex: number, skipPaste: boolean);
        setColStatus(columIndex: number, status: boolean);
        setColStyle(columIndex: number, styleRange: string, styleName: string, styleValue: string);
        setColStyleEx(columIndex: number, style: string, styleRange: string);
        setColStyles(columnIndex: number | number[], style: string, styleRange: string);
        setColumnGroup(columIndex: number, columnGroupInfo: object);
        setColumnHint(columIndex: number, htmlTag: string);
        setColUserAttr(columnIndex: number, userAttr: object);
        setColWidth(columIndex: number, columnWidth: string, refresh?: boolean);
        setDnD(dragDropObj: object);
        setEmptyCellOnPaste(emptyDataCaseInvalidFormat?: boolean);
        setExplorerBar(eventType: string);
        setExtendCol(columIndex: number);
        setExtendLastCol(lastColType: string);
        setFilterOfColumns(fiteringColumn: number | number[], uiType: string);
        setFilters(filterInfo: object[], operator?: object[]);
        setFixedcellcheckbox(rowIndex: number, columIndex: number, allCheckbox?: boolean, hideCaption?: boolean);
        setFixedcellcheckboxChecked(rowIndex: number, columIndex: number, checked?: boolean);
        setFrozenBottomRows(frozenCount: number);
        setFrozenCols(frozenCount: number);
        setFrozenRows(frozenCount: number);
        setHiddenCopyNPaste(enableCopyNPasteHiddenColumn: boolean);
        setMergeCells(mergeType: string);
        setMergeCellsFixedRows(mergeType: string);
        setRow(rowIndex: number);
        setRowData(rowIndex: number, data: object, refresh?: boolean);
        setRowStatus(rowIndex: number, status: number | string);
        setRowStyle(rowIndex: number, styleRange: string, styleName: string, styleValue: string);
        setRowStyleEx(rowIndex: number, style: string, styleRange: string, refresh?: boolean);
        setRowStyles(rowIndex: number | number[], style: string, styleRange: string, refresh?: boolean);
        setSelectionMode(modeType: string);
        setShowSelectedCellsInfo(fxType: string);
        setShowTotalRows(showTotalRowCount: boolean);
        setSortable(columIndex: number, sorting: boolean);
        setTotal(totalInfo: object);
        show();
        showscrollinfo(scrollInfo: object);
        sortColumn(columIndex: number, sortingType: string);
        sortingIcon();
        stopEditing();
        unbind(eventName: string);
    }
}
