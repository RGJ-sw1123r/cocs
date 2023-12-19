/**
 *		그리드 각종 설정 정보
 *		_SBGrid.CF.LOCALE : locale 설정 정보 (Object type)
 *
 *		locale 						: 그리드에 설정하려는 locale 코드 지정 (String Type)
 *		localeinfo 					: locale 코드별 설정 정보 지정 (Object type)
 *		localeinfo.코드 				: locale 코드 (Object Type)
 *		localeinfo.코드.datepicker	: 달력 locale 설정 (String Type)
 *			'ko' > 한국어
 *			'ar' > 아랍어
 *			'en' > 영어
 *			'de' > 독일어
 *			'es' > 스페인어
 *			'ja' > 일본어
 *			'zh-CN' > 중국어
 *		localeinfo.코드.caption		: 캡션 지정 (Array Type)
 *		localeinfo.코드.format		: format 지정 (Object Type)
 *		localeinfo.코드.format.rule	: format rule 지정 (String Type)
 *
 */

_SBGrid.CF.LOCALE = {
	'locale': 'JP',
	'localeinfo': {
		'K1': {
			'datepicker': 'ko',
			'caption': [['데이타'], ['날짜데이타'], ['날짜2데이타'], ['숫자데이타'], ['숫자2데이타'], ['달력데이타']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'C1': {
			'datepicker': 'zh-CN',
			'caption': [['数据'], ['日期-数据'], ['日期2-数据'], ['數字-数据'], ['數字2-数据'], ['月历-数据']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'A9': {
			'datepicker': 'en-AU',
			'caption': [['DATA'], ['DATE-DATA'], ['DATE1-DATA'], ['NUMBER-DATA'], ['NUMBER2-DATA'], ['CALENDAR-DATA']],
			'format': {
				'date': {
					'rule': 'dd-mm-yyyy'
				},
				'number': {
					'rule': '#,###'
				}
			}
		},
		'A7': {
			'datepicker': 'en-AU',
			// 'caption': [['DATA'], ['DATE-DATA'], ['DATE1-DATA'], ['NUMBER-DATA'], ['NUMBER2-DATA'], ['CALENDAR-DATA']],
			'caption': [['COL1'], ['COL2'], ['COL3'], ['COL4'], ['COL5'], ['COL6'],['COL7'],['COL8'],['COL9'],['COL10'],['COL11'],['COL12']],
			// 'caption': [['Academy','COL1'], ['Academy','COL2'], ['Academy','COL3'], ['Academy','COL4'], ['Academy','COL5'], ['Class','COL6'],['Class','COL7'],['Class','COL8'],['Class','COL9'],['Class','COL10'],['Class','COL11'],['Class','COL12']],
			'format': {
				'date': {
					'rule': 'dd-mm-yyyy'
				},
				'number': {
					'rule': '#,###.00',
					'digitgroup': '.',
					'decimalgroup': ','
				}
			},
			'extendLanguage': {
				'filteringtabname': {
					'checklist' : '값 검색-us',
					'text' : '조건 검색-us',
					'number' : '조건 검색-us',
					'datepicker' : '조건 검색-us',
					'combo' : '조건 검색-us',
				},
				'filtering': {
					'filteringtitle': 'Filtering-us',
					'unSelected': '설정 되지 않음.-us',
					'prefix' : '다음-us',
					'of' : '의 -us',
					'and' : '과 -us',
					'selectAll': '전체선택-us',
					'or': '거나-us',
					'okBtn': '적용-us',
					'resetBtn': '전체 초기화-us',
					'removeBtn': '지움-us',
					'greater': '크-us',
					'less': '작-us',
					'equal': '같-us',
					'notEqual': '같지 않-us',
					'include': '값을 포함하-us',
					'notInclude': '값을 포함하지 않-us',
					'startWith': '값으로 시작하-us',
					'endWith': '값으로 끝나-us',
					'end': '다-us'
				},
				'finddata': {
					'title': 'Search-us',
					'caseSensitive': '대소문자 구분-us',
					'wholeWord': '전체 일치-us',
					'find': '검색-us',
					'findBtn': '찾기-us',
					'closeBtn': '닫기-us'
				},
				'selectedcellsinfo': {
					'selected': '선택된 셀의-us',
					'count': '개수-us',
					'sum': '합계-us',
					'avg': '평균-us'
				},
				'totalrows': '전체 행의 개수-us',
				'controlpanelcolumns': {
					'column': '컬럼명-us',
					'frozen': '고정-us',
					'width': '너비-us',
					'filtering': '필터링-us',
					'okBtn': '적용-us',
					'cancelBtn': '취소-us'
				},
				'paging': '이동-us',
			}
		},
		'KO': {
			'datepicker': 'ko',
			'caption': [['학원명'], ['설립자(성명)'], ['전화번호'], ['학원주소'], ['교습과정'], ['교습과목(반)'],['정원'],['교습기간'],['교육시작일'],['총교습시간(분)'],['교습비'],['강사수']],
			// 'caption': [['기본정보','학원명'], ['기본정보','설립자(성명)'], ['기본정보','전화번호'], ['기본정보','학원주소'], ['기본정보','교습과정'], ['상세정보','교습과목(반)'],['상세정보','정원'],['상세정보','교습기간'],['상세정보','교육시작일'],['상세정보','총교습시간(분)'],['상세정보','교습비'],['상세정보','강사수']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			},
			'extendLanguage': {
				'filteringtabname': {
					'checklist' : '값 검색',
					'text' : '조건 검색',
					'number' : '조건 검색',
					'datepicker' : '조건 검색',
					'combo' : '조건 검색',
				},
				'filtering': {
					'filteringtitle': 'Filtering',
					'unSelected': '설정 되지 않음.',
					'prefix' : '다음',
					'of' : '의 ',
					'and' : '과 ',
					'selectAll': '전체선택',
					'or': '거나',
					'okBtn': '적용',
					'resetBtn': '전체 초기화',
					'removeBtn': '지움',
					'greater': '크',
					'less': '작',
					'equal': '같',
					'notEqual': '같지 않',
					'include': '값을 포함하',
					'notInclude': '값을 포함하지 않',
					'startWith': '값으로 시작하',
					'endWith': '값으로 끝나',
					'end': '다'
				},
				'finddata': {
					'title': 'Search',
					'caseSensitive': '대소문자 구분',
					'wholeWord': '전체 일치',
					'find': '검색',
					'findBtn': '찾기',
					'closeBtn': '닫기'
				},
				'selectedcellsinfo': {
					'selected': '선택된 셀의',
					'count': '개수',
					'sum': '합계',
					'avg': '평균'
				},
				'totalrows': '전체 행의 개수',
				'controlpanelcolumns': {
					'column': '컬럼명',
					'frozen': '고정',
					'width': '너비',
					'filtering': '필터링',
					'okBtn': '적용',
					'cancelBtn': '취소'
				},
				'paging': '이동',
			}
		},
		'JP': {
			'datepicker': 'ja',
			'caption': [['学院名'], ['成立者（生命）'], ['電話番号'], ['学院住所'], ['教習課程'], ['教習科目(クラス)'],['定員'],['教習期間'],['教育開始日'],['総レッスン時間(分)'],['教習費'],['講師数']],
			// 'caption': [['基本情報','学院名'], ['基本情報','成立者（生命）'], ['基本情報','電話番号'], ['基本情報','学院住所'], ['基本情報','教習課程'], ['詳細情報','教習科目(クラス)'],['詳細情報','定員'],['詳細情報','教習期間'],['詳細情報','教育開始日'],['詳細情報','総レッスン時間(分)'],['詳細情報','教習費'],['詳細情報','講師数']],
			'format': {
				'date': {
					'rule': 'yyyy-mm-dd'
				},
				'number': {
					'rule': '#,###'
				}
			},
			'extendLanguage': {
				'filteringtabname': {
					'checklist' : '값 검색-jp',
					'text' : '조건 검색-jp',
					'number' : '조건 검색-jp',
					'datepicker' : '조건 검색-jp',
					'combo' : '조건 검색-jp',
				},
				'filtering': {
					'filteringtitle': 'Filtering-jp',
					'unSelected': '설정 되지 않음.-jp',
					'prefix' : '다음-jp',
					'of' : '의 -jp',
					'and' : '과 -jp',
					'selectAll': '전체선택-jp',
					'or': '거나-jp',
					'okBtn': '적용-jp',
					'resetBtn': '전체 초기화-jp',
					'removeBtn': '지움-jp',
					'greater': '크-jp',
					'less': '작-jp',
					'equal': '같-jp',
					'notEqual': '같지 않-jp',
					'include': '값을 포함하-jp',
					'notInclude': '값을 포함하지 않-jp',
					'startWith': '값으로 시작하-jp',
					'endWith': '값으로 끝나-jp',
					'end': '다-jp'
				},
				'finddata': {
					'title': 'Search-jp',
					'caseSensitive': '대소문자 구분-jp',
					'wholeWord': '전체 일치-jp',
					'find': '검색-jp',
					'findBtn': '찾기-jp',
					'closeBtn': '닫기-jp'
				},
				'selectedcellsinfo': {
					'selected': '선택된 셀의-jp',
					'count': '개수-jp',
					'sum': '합계-jp',
					'avg': '평균-jp'
				},
				'totalrows': '전체 행의 개수-jp',
				'controlpanelcolumns': {
					'column': '컬럼명-jp',
					'frozen': '고정-jp',
					'width': '너비-jp',
					'filtering': '필터링-jp',
					'okBtn': '적용-jp',
					'cancelBtn': '취소-jp'
				},
				'paging': '이동-jp',
			}
		}
	}
};
