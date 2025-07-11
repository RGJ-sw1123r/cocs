(function() {
    SBUxG.DEF.MSG = {
        // LICENSE
        NOT_FOUND_LICENSE: '[SBUx] ライセンスが登録されていませんでした。',
        INVALID_LICENSE: '[SBUx] ライセンスは無効です。',
        EXPIRED_LICENSE: '[SBUx] このライセンスは有効期限が切れています。',
        UNMATCH_VER_LICENSE: '[SBUx] ライセンスが一致しない製品バージョンです',

        // COMMON
        NOT_DEV_API: '[SBUx] SBUxMethod.${attr} API は未開発の機能です。',
        NOT_DEV_FUNC: '[SBUx] ${attr}コンポーネントの ${attr1} は未開発の機能です。',
        NOT_FOUND_TAG: '[SBUx] タグ名が見つかりません。名前：${attr}',
        NOT_ENTERED_INVALID_TAG: '[SBUx] 正しいタグ名、間違ったタグを入力してください。名前：${attr}',
        NOT_ENTERED_ATTR: '[SBUx] ${attr} が入力されていませんでした。',
        NOT_PROVIDE_ATTR: '[SBUx] ${attr} このプロパティでは機能を提供しません。',
        NOT_PROVIDE_ATTR_ATTR: '[SBUx] ${attr1}, ${attr} このプロパティでは機能を提供しません。',
        NOT_PROVIDE_FUNC: '[SBUx] ${attr} はすぐに利用できません。',
        NOT_ENTERED_ID: '[SBUx] idが入力されていませんでした。',
        NOT_ENTERED_NAME: '[SBUx] nameが入力されていませんでした。',
        NOT_ENTERED_UITYPE: '[SBUx] uitypeが入力されていませんでした。',
        NOT_ENTERED_MODE: '[SBUx] modeが入力されていませんでした。',
        NOT_ENTERED_REQ_ATTRI: '[SBUx] 必須属性が入力されていませんでした。',
        NOT_EXIST_FORMNAME: '[SBUx] Form Nodeのnameが必要です。',
        NOT_EXIST_FORMID: '[SBUx] Form Nodeのidが必要です。',
        OVER_PARAMS: '[SBUx] パラメータ数は、最大10台までサポートします。',
        INVALID_UITYPEVALUE: '[SBUx] 誤ったuitype属性の値が入力されてい。スペルを確認してください。',
        INVALID_ATTRIVALUE: '[SBUx] 無効なプロパティの値が入力されます。スペルを確認してください。',
        INVALID_ATTRIVALUE_COUNT: '[SBUx] 不足している属性値が入力されます。',
        INVALID_ATTRIVALUE_SPACE: '[SBUx] 空白であるか、スペースは許可されません。',
        INVALID_ATTRIVALUE_UNDEFINED: '[SBUx] 未定義は許可されません。',
        MUST_ATTRIVALUE : '[SBUx] 属性値を設定する必要があります。[${attr}]',

        NOT_FOUND_TEXT: '検出された結果がありません',

        INFORMATION_TEXT : '情報',

        // MESSAGE
        MESSAGE_NOT_FOUND_NAME: '[SBUx] 参照することができるnameがありません。',
        MESSAGE_NOT_FOUND_ID: '[SBUx] 参照することができるidがありません。',

        // VALIDATE
        MESSAGE_ONLY_NUMBER: '[SBUx] 番号を入力する必要があります。',
        MESSAGE_ONLY_STRING: '[SBUx] 文字のみを入力することができます。',
        MESSAGE_ONLY_BOOLEAN: '[SBUx] これは、真または偽の入力でなければなりません。',
        MESSAGE_ONLY_PHONE_NUMBER: '[SBUx] 電話番号は数字のみで入力できます',
        MESSAGE_NOT_ALLOWED_RANGE: '[SBUx] 許容範囲外',
        MESSAGE_NOT_ALLOWED_DIGIT: '[SBUx] 小数点は許容ません。',
        MESSAGE_NOT_ALLOWED_MINUS: '[SBUx] マイナスの値は許容ません。',
        MESSAGE_NOT_ALLOWED_STRING: '[SBUx] 文字は許容値です。',
        MESSAGE_NOT_ALLOWED_SPACE: '[SBUx] 空白は許容ません。',

        // DATEPICKER
        DATEPICKER_INPUT_FROM_TEXT : '日付から',
        DATEPICKER_INPUT_TO_TEXT : '現在まで',

        // RADIO
        RADIO_NO_DATA: '未定義',

        // CHECKBOX
        CHECKBOX_NO_DATA: '未定義',

        // SELECT BOX
        SELECT_NO_DATA: 'データなし',
        SELECT_UNSELECTED: '選択してください',
        IS_SELECT_ALL_TEXT: 'すべて選択',
        TITLE_SELECT_MAX_TEXT: ' 選択しました',
        TITLE_SELECT_ALL_TEXT: 'すべて選択',
        SELECT_MAX_COUNT_TEXT : '${attr}つまで選択できます。',

        // LISTBOX
        LISTBOX_NO_DATA: '',

        // TREE
        SELECT_NODE_NEED_TITLE: 'Tree Info',
        SELECT_NODE_NEED: '選択されたノードが必要とされます。',
        INVALID_NODE_INFO: '無効なノード情報。',
        AVAILABLE_JSONDATA_TYPE: 'それだけでJsonDataを形成することができます',
        NEW_TREE_NODE_TEXT: '新規ノード',
        NEW_TREE_NODE_CREATION_FAILED : 'ノードの作成に失敗しました',
        NEW_TREE_NODE_VALUE: '',
        INFO_DELETE_CHILD_NODE: '子ノードも削除されます',
        INFO_DELETE_NODE: 'ノードを削除します。',
        NODE_DUPLICATION_KEY: 'キーのノードを重複が発生しました。製品会社にお問い合わせください',
        TREE_NO_DATA : 'データなし',

        // ALERT
        CONFIRM_OK: '確認します',
        CONFIRM_CANCEL: 'キャンセル',
        CLOSE_ON_FOOTER: '確認します',

        // DROPDOWN TEXT
        DROPDOWN_TEXT: '選択してください',

        // COLSE TEXT
        CLOSE_TEXT: '閉じる',

        // TAB TEXT
        TAB_MENU_LIST_DEL_CONFIRM_TITLE : 'Tab Info',
        TAB_MENU_LIST_DEL_ALL_DESC : 'タブ全体を閉じますか？',
        TAB_MENU_LIST_DEL_FOCUS_DESC : '現在のタブを閉じますか？',
        TAB_MENU_LIST_DEL_EXCEPT_FOCUS_DESC : '現在のタブ以外のタブを閉じますか？',
        TAB_MENU_LIST_DEL_EXCEPT_FIXED_DESC : '您是否要关闭除固定标签以外的标签？',

        TAB_DONT_CLOSE : '他のすべてのタブは非アクティブです。',
        TAB_OPEN_NOTFOUND_LINK : '接続された画面が存在しません。',
        TAB_DONT_REMOVE : '削除するタブは存在しません。',
        TAB_MENU_LIST_DEL_ALL : '全タブの削除',
        TAB_MENU_LIST_DEL_FOCUS : 'フォーカスタブを削除',
        TAB_MENU_LIST_DEL_EXCEPT_FOCUS : '固定タブ以外は取り外す',
        TAB_MENU_LIST_DEL_EXCEPT : ',固定タブ以外は取り外す',
        TAB_MENU_DONT_REMOVE : '削除することができません。',
        TAB_MENU_CLOSE_CONFIRM_TEXT : '',

        // PROGRESS BAR
        PROGRESS_NOT_ALLOWED_TWOBAR : '"indicator-type"属性が "normal value"の場合は、 "sbux-bar"タグを1つだけ設定する必要があります。',
        PROGRESS_LOADING_TEXT : 'LOADING',

        // CONTEXT MENU
        CTXT_MENU_DATA_COLLECT : '[SBUx] 子ノードからのデータの収集中にエラーが発生しました。',
        CTXT_MENU_INVALID_SELECTOR : '[SBUx] ${attr}のセレクタをチェックしてください。',

        // SBGRID
        NOT_ENTERED_COLUMS: '[SBUx] 参照することができるカラム情報がありません。',
        NOT_ENTERED_STYLE : '[SBUx] グリッドの幅と高さを決めるスタイル情報はありません。',
        NO_ROWS_SELECTED : '[SBUx] グリッド内の行を選択する必要があります。',

        // IE9 Required
        IE9_NOT_ENTERED_REQ_COMMON: 'それは必須です。',
        IE9_NOT_ENTERED_REQ_INPUT: 'このフィールドを作成してください。',
        IE9_NOT_ENTERED_REQ_SELECT: 'リストから項目を選択してください。',
        IE9_NOT_ENTERED_REQ_CHECK: '必須オプションです。',
        IE9_NOT_ENTERED_REQ_RADIO: '必須オプションです。',
        IE9_NOT_ENTERED_REQ_PICKER: '日付を選択してください',
        IE9_NOT_ENTERED_REQ_DROPDOWN: 'リストから項目を選択してください。',

        // Minlength
        IE_MINLENGTH_REQ_INPUT : 'このテキストを*文字以上にしてください（現在使用中の#文字です）。',

        // integer maxlength
        INTEGER_MAXLENGTH_REQ_INPUT : 'この整数値を*文字以下に制限します（現在は＃文字が使用されています）。',
        INTEGER_MINLENGTH_REQ_INPUT : 'この整数値を少なくとも*文字（現在は＃文字が使用中）に増やしてください。',

        // DATA STORE
        DATA_RECEIVE_LOADING_TITLE: 'データの読み込み中',
        DATA_RECEIVE_LOADING_TEXT: 'しばらくお待ちください',
        DATA_RECEIVE_ERROR_TITLE: 'データの読み込みエラー',
        DATA_RECEIVE_ERROR_TEXT: 'ネットワーク接続の状態を確認してください。',
        DATA_SEND_JSONDATA_ERROR: '[SBUx] 文法エラーがあるSend Dataです。',
        DATA_NETWORK_ERROR_TITLE: 'ネットワーク接続エラーが発生しました。',
        DATA_NETWORK_ERROR_TEXT: '問題は、ネットワーク接続で発生しました。',

        // COMMON ERROR_MSG
        JSONDATA_MUST_HAVE: 'jsondata-ref 属性は必須です。',
        JSONDATA_NOT_FOUND: 'jsondata-ref に関連付けられているオブジェクトを見つけることができません。',
        JSONDATA_ALREADY_CHANGED: 'JSON形式の変更がすでにあります。プロパティ、データストアを削除してください - データ型= 「 JSON 」を',

        // SBGrid
        SBGRID21_NOT_IMPORT: '[SBUx] SBGrid 2.1ファイルが見つかりません。 SBUxConfig 設定で   SBGrid : { Version2_1 : true }  変更してください。',
        SBGRID25_NOT_IMPORT: '[SBUx] SBGrid 2.5ファイルが見つかりません。 SBUxConfig 設定で   SBGrid : { Version2_5 : true }  変更してください。',

        // Carousel
        CAROUSEL_NOT_FOUND : '表示するスライドがありません。',

        // Side menu
        SIDEMENU_NO_DATA : 'データなし',
        SIDEMENU_FILTER_PLACEHOLDER : 'サーチ',

        // floating
        FLOATING_NO_DATA : 'データなし',
        FLOATING_FILTER_PLACEHOLDER : 'サーチ',

        // Fileupload
        HEADER_TITLE : '添付ファイル一覧',
        HEADER_FILENAME : 'ファイル名',
        ADD_FILE : '追加ファイル',
        CANCEL_FILE : 'ファイルをキャンセル',
        UPLOAD_ALL_FILE : 'すべてアップロード',
        DELETE_FILE : 'ファイルを削除する',

        // Web Editor Button
        EDITOR_BUTTON_PARAGRAPH : '段落',
        EDITOR_BUTTON_BOLD   : '大胆な',
        EDITOR_BUTTON_UNDERLINE  : '下線',
        EDITOR_BUTTON_ITALIC : 'イタリック',
        EDITOR_BUTTON_STROKE : 'ストロークスルー',
        EDITOR_BUTTON_BULLET_LIST : '箇条書きリスト',
        EDITOR_BUTTON_NUM_LIST : '数値リスト',
        EDITOR_BUTTON_PICTURE : '画像',
        EDITOR_BUTTON_LINK : 'リンク',
        EDITOR_BUTTON_CLEAN : 'クリーン',
        EDITOR_BUTTON_PREVIEW : 'プレビュー',

        EDITOR_BUTTON_PICTURE_MSG : '画像のURL',
        EDITOR_BUTTON_PICTURE_ALT_MSG : '代替テキスト',
        EDITOR_BUTTON_LINK_MSG : 'テキストリンク',

        // image viewer
        IMAGEVIEWER_UNTITLED : '無題',

        // web accessibility
        WEB_ACCESS_UNTITLED : '無題',

        // localstorage
        TO_USE_LOCALSTORAGE : 'SBUxConfig設定でSystemLogType： "storage"またはDeveloperTipType： "storage"を使用するには、アドレスバーでは、httpまたはhttpsで始まる必要があります。 システムを動作させるための "console" タイプに変更してください。'
    };

    SBUxG.DEF.MSG_VALIDATE = {
        INPUT : '入力条件を確認してください',
        DATEPICKER : '日付入力条件を確認してください',
        RADIO : '選択条件をご確認ください',
        CHECKBOX : '選択条件をご確認ください',
        SELECT : '選択条件をご確認ください',
        TEXTAREA : '入力条件を確認してください',
        LISTBOX : '選択条件をご確認ください',
        DROPDOWN : '選択条件をご確認ください'
    };

}());