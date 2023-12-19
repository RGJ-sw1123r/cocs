/*
 * sbTotal.js, subtotal , grandtotoal
 */

var SBTotal;
(function (SBTotal) {
   // 사용여부를 판단	 
   var bUseTotal = false;
   var isUseTotal = (function () {
		  return bUseTotal;
   });
   
   var Convert = (function () {
	   
	  function Convert(convertInfo, orgGridJson,objColumnsInfo) {
		  bUseTotal = true;
		  
		  convertInfo.base.objColumnsInfo = _.clone(objColumnsInfo);
		  
		  // program sort 지정시
		  if (convertInfo.base.isProgramSort) step_1_dataSort(convertInfo, orgGridJson);
		  
		  // isDuplicationKey : false,  // 키에 대한 데이터 중복 허용여부, false 인경우 sum , true 인경우 그대로
		  if (convertInfo.base.isDuplicationKey){   
			  // key 에 대해 unique 하지 않은 경우
			  step_2_duplicationGroup(convertInfo,orgGridJson);
		  } else {
			  // key 에 대해 unique 한 경우
			  step_2_uniqueGroup(convertInfo,orgGridJson);
		  }		
		  
		  step_3_index_total_subtotal(convertInfo);
		  
		  step_4_insert_total_subtotal(convertInfo,orgGridJson);
		  
		  orgGridJson = convertInfo.base.data;		  
      };
      
      return Convert;
      
   })();
   SBTotal.Convert = Convert;
   SBTotal.isUseTotal = isUseTotal;
   
   
   
   //=========================================================
   // 그리드 데이터 재배치
   //=========================================================
   function step_1_dataSort(convertInfo, orgGridJson){
   	   cmp = function(x, y){
            return x > y ? 1 : x < y ? -1 : 0; 
       };
        
       var pivotSort = function(a,b){
        	  // 다중
        	 	 if (convertInfo.base.keyByRef.length == 1){
        	 		 if(eval('a.'+convertInfo.base.keyByRef) == eval('b.'+convertInfo.base.keyByRef) ){ return 0;}	    	 
   	     		 return  eval('a.'+convertInfo.base.keyByRef) > eval('b.'+convertInfo.base.keyByRef) ? 1 : -1; 	    	 
        		 
        	 	 }else if (convertInfo.base.keyByRef.length == 2){
        			 return cmp( 
        		 		        [cmp(eval('a.'+convertInfo.base.keyByRef[0]), eval('b.'+convertInfo.base.keyByRef[0])), cmp(eval('a.'+convertInfo.base.keyByRef[1]), eval('b.'+convertInfo.base.keyByRef[1]))], 
        		 		        [cmp(eval('b.'+convertInfo.base.keyByRef[0]), eval('a.'+convertInfo.base.keyByRef[0])), cmp(eval('b.'+convertInfo.base.keyByRef[1]), eval('a.'+convertInfo.base.keyByRef[1]))]
        		 		 );
        		 } else if (convertInfo.base.keyByRef.length == 3){
        			 return cmp( 
        		 		        [cmp(eval('a.'+convertInfo.base.keyByRef[0]), eval('b.'+convertInfo.base.keyByRef[0])), cmp(eval('a.'+convertInfo.base.keyByRef[1]), eval('b.'+convertInfo.base.keyByRef[1])), cmp(eval('a.'+convertInfo.base.keyByRef[2]), eval('b.'+convertInfo.base.keyByRef[2]))], 
        		 		        [cmp(eval('b.'+convertInfo.base.keyByRef[0]), eval('a.'+convertInfo.base.keyByRef[0])), cmp(eval('b.'+convertInfo.base.keyByRef[1]), eval('a.'+convertInfo.base.keyByRef[1])), cmp(eval('b.'+convertInfo.base.keyByRef[2]), eval('a.'+convertInfo.base.keyByRef[2]))]
        		 		 );
        		 } else if (convertInfo.base.keyByRef.length == 4){
        			 return cmp( 
        		 		        [cmp(eval('a.'+convertInfo.base.keyByRef[0]), eval('b.'+convertInfo.base.keyByRef[0])), cmp(eval('a.'+convertInfo.base.keyByRef[1]), eval('b.'+convertInfo.base.keyByRef[1])), cmp(eval('a.'+convertInfo.base.keyByRef[2]), eval('b.'+convertInfo.base.keyByRef[2])), cmp(eval('a.'+convertInfo.base.keyByRef[3]), eval('b.'+convertInfo.base.keyByRef[3]))], 
        		 		        [cmp(eval('b.'+convertInfo.base.keyByRef[0]), eval('a.'+convertInfo.base.keyByRef[0])), cmp(eval('b.'+convertInfo.base.keyByRef[1]), eval('a.'+convertInfo.base.keyByRef[1])), cmp(eval('b.'+convertInfo.base.keyByRef[2]), eval('a.'+convertInfo.base.keyByRef[2])), cmp(eval('b.'+convertInfo.base.keyByRef[3]), eval('a.'+convertInfo.base.keyByRef[3]))]
        		 		 );
        		 } else if (convertInfo.base.keyByRef.length == 5){
        			 return cmp( 
        		 		        [cmp(eval('a.'+convertInfo.base.keyByRef[0]), eval('b.'+convertInfo.base.keyByRef[0])), cmp(eval('a.'+convertInfo.base.keyByRef[1]), eval('b.'+convertInfo.base.keyByRef[1])), cmp(eval('a.'+convertInfo.base.keyByRef[2]), eval('b.'+convertInfo.base.keyByRef[2])), cmp(eval('a.'+convertInfo.base.keyByRef[3]), eval('b.'+convertInfo.base.keyByRef[3])), cmp(eval('a.'+convertInfo.base.keyByRef[4]), eval('b.'+convertInfo.base.keyByRef[4]))], 
        		 		        [cmp(eval('b.'+convertInfo.base.keyByRef[0]), eval('a.'+convertInfo.base.keyByRef[0])), cmp(eval('b.'+convertInfo.base.keyByRef[1]), eval('a.'+convertInfo.base.keyByRef[1])), cmp(eval('b.'+convertInfo.base.keyByRef[2]), eval('a.'+convertInfo.base.keyByRef[2])), cmp(eval('b.'+convertInfo.base.keyByRef[3]), eval('a.'+convertInfo.base.keyByRef[3])), cmp(eval('b.'+convertInfo.base.keyByRef[4]), eval('a.'+convertInfo.base.keyByRef[4]))]
        		 		 );
        		 } else if (convertInfo.base.keyByRef.length == 6){
        			 return cmp( 
        		 		        [cmp(eval('a.'+convertInfo.base.keyByRef[0]), eval('b.'+convertInfo.base.keyByRef[0])), cmp(eval('a.'+convertInfo.base.keyByRef[1]), eval('b.'+convertInfo.base.keyByRef[1])), cmp(eval('a.'+convertInfo.base.keyByRef[2]), eval('b.'+convertInfo.base.keyByRef[2])), cmp(eval('a.'+convertInfo.base.keyByRef[3]), eval('b.'+convertInfo.base.keyByRef[3])), cmp(eval('a.'+convertInfo.base.keyByRef[4]), eval('b.'+convertInfo.base.keyByRef[4])), cmp(eval('a.'+convertInfo.base.keyByRef[5]), eval('b.'+convertInfo.base.keyByRef[5]))], 
        		 		        [cmp(eval('b.'+convertInfo.base.keyByRef[0]), eval('a.'+convertInfo.base.keyByRef[0])), cmp(eval('b.'+convertInfo.base.keyByRef[1]), eval('a.'+convertInfo.base.keyByRef[1])), cmp(eval('b.'+convertInfo.base.keyByRef[2]), eval('a.'+convertInfo.base.keyByRef[2])), cmp(eval('b.'+convertInfo.base.keyByRef[3]), eval('a.'+convertInfo.base.keyByRef[3])), cmp(eval('b.'+convertInfo.base.keyByRef[4]), eval('a.'+convertInfo.base.keyByRef[4])), cmp(eval('b.'+convertInfo.base.keyByRef[5]), eval('a.'+convertInfo.base.keyByRef[5]))]
        		 		 );
        		 } else if (convertInfo.base.keyByRef.length == 7){
        			 return cmp( 
        		 		        [cmp(eval('a.'+convertInfo.base.keyByRef[0]), eval('b.'+convertInfo.base.keyByRef[0])), cmp(eval('a.'+convertInfo.base.keyByRef[1]), eval('b.'+convertInfo.base.keyByRef[1])), cmp(eval('a.'+convertInfo.base.keyByRef[2]), eval('b.'+convertInfo.base.keyByRef[2])), cmp(eval('a.'+convertInfo.base.keyByRef[3]), eval('b.'+convertInfo.base.keyByRef[3])), cmp(eval('a.'+convertInfo.base.keyByRef[4]), eval('b.'+convertInfo.base.keyByRef[4])), cmp(eval('a.'+convertInfo.base.keyByRef[5]), eval('b.'+convertInfo.base.keyByRef[5])), cmp(eval('a.'+convertInfo.base.keyByRef[6]), eval('b.'+convertInfo.base.keyByRef[6]))], 
        		 		        [cmp(eval('b.'+convertInfo.base.keyByRef[0]), eval('a.'+convertInfo.base.keyByRef[0])), cmp(eval('b.'+convertInfo.base.keyByRef[1]), eval('a.'+convertInfo.base.keyByRef[1])), cmp(eval('b.'+convertInfo.base.keyByRef[2]), eval('a.'+convertInfo.base.keyByRef[2])), cmp(eval('b.'+convertInfo.base.keyByRef[3]), eval('a.'+convertInfo.base.keyByRef[3])), cmp(eval('b.'+convertInfo.base.keyByRef[4]), eval('a.'+convertInfo.base.keyByRef[4])), cmp(eval('b.'+convertInfo.base.keyByRef[5]), eval('a.'+convertInfo.base.keyByRef[5])), cmp(eval('b.'+convertInfo.base.keyByRef[6]), eval('a.'+convertInfo.base.keyByRef[6]))]
        		 		 );
        		 }     	    	
       };
        
        orgGridJson.sort(pivotSort);
   }
   
   //=========================================================
   // duplication 그룹으로 key 중복 허용 데이터
   //=========================================================
   function step_2_duplicationGroup(convertInfo,orgGridJson){
   	 
       var groupRef = convertInfo.base.keyByRef;
   	 
   	   var arrTempGroupData = [];
   	   var arrGroupData = [];
   	 
   	   $.each( orgGridJson , function(gridIndex){    		 
   		   arrGroupData.push(orgGridJson[gridIndex]);
   	   });
   	   convertInfo.base.data = arrGroupData;
   	   
   	   //console.log("step_2_duplicationGroup" , convertInfo.base.data);
   }
   
   //=========================================================
   // unique 한 그룹으로 데이터를 재조합함
   //=========================================================
   function step_2_uniqueGroup(convertInfo,orgGridJson){
   	 
       var groupRef = convertInfo.base.keyByRef;
   	 
   	   var arrTempGroupData = [];
   	   var arrGroupData = [];
   	 
   	   $.each( orgGridJson , function(gridIndex){    		 
   	       var groupStr='';
   		 
   	       var tmpKey = '';
   	       var tmpGropuStr = '';
       	   $.each( groupRef, function(columnIndex){
       	       tmpKey = eval("orgGridJson["+gridIndex+"]."+groupRef[columnIndex]);
       	    tmpGropuStr += ',"'+ groupRef[columnIndex] +'" : "' + tmpKey + '" ';	       		   
       	   });
       	   groupStr = '{' + tmpGropuStr.substring(1) + '}';
       	        	   
       	   // 서로 다른 데이터 라면 
       	   if (_.contains(arrTempGroupData, groupStr ) == false) {
       	       arrTempGroupData.push(groupStr);
       		   //arrGroupData.push($.parseJSON(groupStr));
       	       //arrGroupData.push($.parseJSON(orgGridJson[gridIndex])); 
       	       
       	       // groupStr 을 기준으로 나머지 데이터 값을 합친다. 가져와서 합친다.       	       
       	       var groupStrData = _.where(orgGridJson, $.parseJSON(groupStr) );
       	       if (_.size(groupStrData) > 1) {
       	    	   // 데이터가 여러개 있는 경우
       	    	   var sumGroupData = '';
       	    	   $.each(groupStrData[0], function(innerDataIndex){
       	    		   if (_.contains(groupRef, innerDataIndex)) return true; // continue;
       	    		   
       	    		   var innerDataGroup = _.pluck(groupStrData,innerDataIndex );
       	    		   var innerDataSum = _.reduce(_.compact(innerDataGroup), function(data1, data2){   
       	    			       if (isNumber(data1) && isNumber(data2)){ 
       	    			    	   return Number(data1) + Number(data2);    
       	    			       } else {
       	    			    	   return data1 + data2;    
       	    			       }      	    			
       	    			   } , '' );
       	    		   
       	    		   sumGroupData += ',"'+ innerDataIndex +'" : "' + innerDataSum + '" ';	 
       	    	   });
       	    	   sumGroupData = '{' + tmpGropuStr.substring(1) +  sumGroupData + '}';
       	    	   
       	    	   arrGroupData.push($.parseJSON(sumGroupData));
       	    	   
       	       } else {
       	    	   // 데이터가 하나만 있는 경우
       	    	 arrGroupData.push(orgGridJson[gridIndex]);
       	       }
       	   } 
   	   });
   	   convertInfo.base.data = arrGroupData;
   	   
   	   //console.log("step_2_uniqueGroup" , convertInfo.base.data);
   }
   
   
   //=========================================================
   // total 및 subtotal 입력
   //=========================================================
   function step_3_index_total_subtotal(convertInfo){
  	 // convertInfo.base.data 에 값을 넣어야 하기 때문에 증가
       var clonefixedPatternData = [];
   	 
   	   // subtotal 비교를 위한 Compare Array
   	   var collectionData = {
   			 					compare : {
										 		previousData : new Array(convertInfo.subTotal.length),
										 		currentData : new Array(convertInfo.subTotal.length)    	                               
   			 							  },
								text    : {
										 		setupRefData : new Array(convertInfo.subTotal.length),
										 		otherRefData : new Array(convertInfo.subTotal.length)
										  },
					   			   temp : {
											 level : {},	
											 title : {},
											 otherLevel : {},
											 addSubTotalOtherLevel : ""
										  }									           
   	 						};    	 
   	     	 
	   // 좌측 그룹을 확인하면서 비교
	   $.each(convertInfo.base.data, function(dataIndex){
			 // 최초 값일때는 저장   			 
			 //console.log("DATA " ,dataIndex, convertInfo.base.data[dataIndex]);   			 
			 if (dataIndex == 0){
			     if (!_.isUndefined(convertInfo.total) && !_.isUndefined(convertInfo.total.top)){ 
			    	 $.each(convertInfo.total.top, function(totalIndex){ 
							var addTotal = step_3_total(convertInfo,totalIndex,"top");
							if (addTotal.length > 0) {
									//convertInfo.rowType.push( $.parseJSON('{"'+dataIndex+'":"T" ,"position":"top" } ') );
									convertInfo.rowType.push( $.parseJSON('{"type":"T" ,"position":"top" } ') );
									clonefixedPatternData.push($.parseJSON(addTotal ));
							}
					 });
			     }
			     
			     if (!_.isUndefined(convertInfo.subTotal)){
			    	 $.each(convertInfo.subTotal, function(subTotalIndex){
							step_3_subTotal_previous(convertInfo,collectionData,dataIndex,subTotalIndex);
					 });
			     }
			 } else {
				 
				 if (!_.isUndefined(convertInfo.subTotal)){
					 $.each(convertInfo.subTotal, function(subTotalIndex){      	    		 
						step_3_subTotal_current(convertInfo,collectionData, dataIndex, subTotalIndex );   						
		    		    //console.log("SubTotal " ,subTotalIndex, collectionData.compare.previousData , collectionData.compare.currentData);
						
						// position, top, bottom 정보가 없다면
						if (_.isUndefined(convertInfo.subTotal[subTotalIndex].position)){
							// 정보가 없는 경우는 default 로 bottom 지정
							// 위치 변동은 나중에 합니다.
							convertInfo.subTotal[subTotalIndex].position = "bottom";
						} 
											
		 	    		// 저장된 이전 데이터와 현재의 데이터를 비교하여 다른 것이 있다면, 소계를 넣는다.
		 	    		if (collectionData.compare.previousData[subTotalIndex] != collectionData.compare.currentData[subTotalIndex] ){
		 	    			
		 	    			//console.log("SubTotal " ,subTotalIndex, collectionData.compare.previousData[subTotalIndex] , collectionData.compare.currentData[subTotalIndex]);	 	    			
		 	    			// Json Data 를 만듬
		 	    			var addSubTotalLevel = step_3_subTotal_makeJson(convertInfo,collectionData,subTotalIndex );
		      	          	
		 	    			if (addSubTotalLevel.length > 0) {
		 	    				// arrRowType 에 S 소계표시와 소계가 속해있는 level 의 이하를 넣는다.
		 	    				
		 	    				var arrRowTypeLevel = "";
		 	    				var arrRowTypeSubTotalLevel = "";
		 	    				
		 	    					
	 	    					$.each(collectionData.temp.level, function(tmpIndex){
		 	    					// tmpIndex 가 0 인 것은 상위 묶여지는 그룹이므로 제외한다.
		 	    					if (tmpIndex > 0) arrRowTypeLevel += ',"'+collectionData.temp.level[tmpIndex]+'"';
		 	    					arrRowTypeSubTotalLevel += ',"'+collectionData.temp.level[tmpIndex]+'"';
		 	    				});
		 	    				
		 	    				
		 	    				
		 	    				//var arrRowType = '{"'+dataIndex+'":"S", "subtotallevel": ';
		 	    				var arrRowType = '{"type":"S", "subtotallevel": ';
		 	    				arrRowTypeLevel = arrRowType +  '[ '+ arrRowTypeLevel.substring(1) + ']' + ', "subtotalconfig": [ '+ arrRowTypeSubTotalLevel.substring(1) +' ]' + ', "position":"'+ convertInfo.subTotal[subTotalIndex].position +'","uniqueGroup":"'+collectionData.compare.previousData[subTotalIndex]  +'" }';
		 	    				convertInfo.rowType.push( $.parseJSON(arrRowTypeLevel) );	 	    				
		 	    				
		 	    				clonefixedPatternData.push($.parseJSON(addSubTotalLevel ));
		 	    			}
		 	    			
		 	    			// 비교 데이터 값을 현재의 값으로 변경      	    			
		 	    			step_3_subTotal_previous(convertInfo,collectionData,dataIndex,subTotalIndex);
		 	    		}
		 			 });
				 }
				 
				 	 
			 }
			 //console.log("DATA " ,dataIndex, convertInfo.base.data[dataIndex],collectionData.compare.previousData);
			 
			 var arrRowGroupPrevious = "";
			 $.each(collectionData.compare.previousData, function(tmpIndex){
				// tmpIndex 가 0 인 것은 상위 묶여지는 그룹이므로 제외한다.
				arrRowGroupPrevious += ',"'+collectionData.compare.previousData[tmpIndex]+'"';
			 });
			 
			 //var arrRowGroup = '{"'+dataIndex+'":"D" , "uniqueGroup" : [' + arrRowGroupPrevious.substring(1) + '] }';
			 var arrRowGroup = '{"type":"D" , "uniqueGroup" : [' + arrRowGroupPrevious.substring(1) + '] }';
		     
		     convertInfo.rowType.push( $.parseJSON(arrRowGroup) );
			 //convertInfo.rowType.push( $.parseJSON('{"'+dataIndex+'":"D"}') );
			 clonefixedPatternData.push(convertInfo.base.data[dataIndex]);
			 
			 // 마지막행에 대한 처리
			 //===========================================================================
			 if (dataIndex == convertInfo.base.data.length-1){
				 if (!_.isUndefined(convertInfo.subTotal)){
					 $.each(convertInfo.subTotal, function(subTotalIndex){
		 	    		 
					        step_3_subTotal_current(convertInfo,collectionData, dataIndex, subTotalIndex );
					        
					     // position, top, bottom 정보가 없다면
							if (_.isUndefined(convertInfo.subTotal[subTotalIndex].position)){
								// 정보가 없는 경우는 default 로 bottom 지정
								// 위치 변동은 나중에 합니다.
								convertInfo.subTotal[subTotalIndex].position = "bottom";
							} 
							
				    		var addSubTotalLevel = step_3_subTotal_makeJson(convertInfo,collectionData,subTotalIndex );
			 	          	   	
				    		if (addSubTotalLevel.length > 0) {
		 	    				// arrRowType 에 S 소계표시와 소계가 속해있는 level 의 이하를 넣는다.
		 	    				
		 	    				var arrRowTypeLevel = "";
		 	    				var arrRowTypeSubTotalLevel = "";
		 	    				$.each(collectionData.temp.level, function(tmpIndex){
		 	    					// tmpIndex 가 0 인 것은 상위 묶여지는 그룹이므로 제외한다.
		 	    					if (tmpIndex > 0) arrRowTypeLevel += ',"'+collectionData.temp.level[tmpIndex]+'"';
		 	    					arrRowTypeSubTotalLevel += ',"'+collectionData.temp.level[tmpIndex]+'"';
		 	    				});
		 	    				//var arrRowType = '{"'+dataIndex+'":"S", "subtotallevel": ';
		 	    				var arrRowType = '{"type":"S", "subtotallevel": ';
		 	    				arrRowTypeLevel = arrRowType +  '[ '+ arrRowTypeLevel.substring(1) + ']' + ', "subtotalconfig": [ '+ arrRowTypeSubTotalLevel.substring(1) +' ]' + ', "position":"'+ convertInfo.subTotal[subTotalIndex].position +'","uniqueGroup":"'+collectionData.compare.currentData[subTotalIndex]  +'" }';
		 	    				convertInfo.rowType.push( $.parseJSON(arrRowTypeLevel) );	 	    				
		 	    				
		 	    				clonefixedPatternData.push($.parseJSON(addSubTotalLevel ));
		 	    			};	    		 
			  			 });
				 }
				 
				 if (!_.isUndefined(convertInfo.total) && !_.isUndefined(convertInfo.total.bottom)){
					 $.each(convertInfo.total.bottom, function(totalIndex){ 
							var addTotal = step_3_total(convertInfo,totalIndex,"bottom");
							if (addTotal.length > 0) {
									//convertInfo.rowType.push( $.parseJSON('{"'+dataIndex+'":"T", "position":"bottom"  }') );
									convertInfo.rowType.push( $.parseJSON('{"type":"T", "position":"bottom"  }') );
									clonefixedPatternData.push($.parseJSON(addTotal ));
							};
					 });
				 }
				 
					
				    				
			 };
		 });
   	
  		convertInfo.base.data = clonefixedPatternData;
   	 
   }
   
   
   // Total Json 데이터를 넣는다.
   function step_3_total(convertInfo,totalIndex, rowLocation){
	   	 var strTotalJson = '';
	   	 var strTotalTitle = [];
	   	 if (rowLocation == "top"){
	   		 if (convertInfo.total.top.length <= 0) return strTotalJson;
	   		 strTotalTitle = convertInfo.total.top[totalIndex].title;
	   	 } else if (rowLocation == "bottom"){
	   		 if (convertInfo.total.bottom.length <= 0) return strTotalJson;
	   		 strTotalTitle = convertInfo.total.bottom[totalIndex].title;
	   	 }
	   	 
	   	 $.each(convertInfo.base.keyByRef , function(levelIndex){
					//total 에 에 들어가는 Json 데이터를 만듬
					if (_.isUndefined(strTotalTitle[levelIndex])){
						strTotalJson += ',"' + convertInfo.base.keyByRef[levelIndex] + '" : "" ';
					} else {
						strTotalJson += ',"' + convertInfo.base.keyByRef[levelIndex] + '" : "' + strTotalTitle[levelIndex] + '"';
					}
					
			 });
	   	 
	   	 if (strTotalJson.length > 0) strTotalJson = '{' + strTotalJson.substring(1) + '}';
	   	 
	   	 return strTotalJson;
  	 
   }
   
   //=========================================================
   // subtotal 을 만들기 위한 , 이전값 비교데이터
   // OutPut : ["미국LA건축용도료", "미국LA건축용", "미국LA", "미국"] 모든 데이터를 하나로 연결하여 저장
   //=========================================================
   function step_3_subTotal_previous(convertInfo,collectionData, dataIndex,subTotalIndex){    	
 		 // subtotal 의 배열
 		 collectionData.temp.level = convertInfo.subTotal[subTotalIndex].level;
		 if (_.size(convertInfo.base.except) > 0){
			collectionData.temp.otherLevel = _.omit(_.difference(convertInfo.base.keyByRef , collectionData.temp.level ), convertInfo.base.except);
		 } else{
			collectionData.temp.otherLevel = _.difference(convertInfo.base.keyByRef , collectionData.temp.level );
		 }
 		 
 		 // setupRefData 는 level 는 상위의 레벨값 하나만 입력하게 한다.
 		 collectionData.text.setupRefData[subTotalIndex] = eval("convertInfo.base.data[dataIndex]."+collectionData.temp.level[0]);
 		 collectionData.text.otherRefData[subTotalIndex] = new Array(collectionData.temp.otherLevel.length);
 		
 		 $.each(collectionData.temp.otherLevel, function(levelIndex){    	    				
 			collectionData.text.otherRefData[subTotalIndex][levelIndex] =  eval("convertInfo.base.data[dataIndex]."+collectionData.temp.otherLevel[levelIndex]);	  	    			
 			collectionData.compare.previousData[subTotalIndex] = (levelIndex == 0) ?  eval("convertInfo.base.data[dataIndex]."+collectionData.temp.otherLevel[levelIndex])
                     											 : collectionData.compare.previousData[subTotalIndex] +  eval("convertInfo.base.data[dataIndex]."+collectionData.temp.otherLevel[levelIndex]);
 			
 		 });
 		 collectionData.compare.previousData[subTotalIndex] = (_.size(collectionData.temp.otherLevel) > 0) ? collectionData.compare.previousData[subTotalIndex] + eval("convertInfo.base.data[dataIndex]."+collectionData.temp.level[0])
														    : eval("convertInfo.base.data[dataIndex]."+collectionData.temp.level[0]);	 	
   }
   
   //=========================================================
   // subtotal 을 만들기 위한 , 현재값 비교데이터 
   // OutPut : ["미국LA건축용도료", "미국LA건축용", "미국LA", "미국"]  모든 데이터를 하나로 연결하여 저장
   //=========================================================
   function step_3_subTotal_current(convertInfo,collectionData, dataIndex, subTotalIndex ){
  	// subtotal 의 배열
		 collectionData.temp.level = convertInfo.subTotal[subTotalIndex].level;
		 collectionData.temp.title = convertInfo.subTotal[subTotalIndex].title;
		 // 설정된 컬럼 외의 컬럼을 소계항목에 붙이기 위해 준비
		 if (_.size(convertInfo.base.except) > 0){
			collectionData.temp.otherLevel = _.omit(_.difference(convertInfo.base.keyByRef , collectionData.temp.level ), convertInfo.base.except);
		 } else {
			collectionData.temp.otherLevel = _.difference(convertInfo.base.keyByRef , collectionData.temp.level );
		 }
	
		 collectionData.temp.addSubTotalOtherLevel = '';	
		 $.each(collectionData.temp.otherLevel, function(levelIndex){    	  
		 
			//console.log(collectionData.text.otherRefData[subTotalIndex][levelIndex]);
			if (isNumber(collectionData.text.otherRefData[subTotalIndex][levelIndex])){
				collectionData.temp.addSubTotalOtherLevel += '"'+ eval("collectionData.temp.otherLevel[levelIndex]") +'" : ' + collectionData.text.otherRefData[subTotalIndex][levelIndex] + ', ';
			} else {
				collectionData.temp.addSubTotalOtherLevel += '"'+ eval("collectionData.temp.otherLevel[levelIndex]") +'" : "' + collectionData.text.otherRefData[subTotalIndex][levelIndex] + '", ';
			}
			
		 
			      	    			
			collectionData.compare.currentData[subTotalIndex]  = (levelIndex == 0) ?  eval("convertInfo.base.data[dataIndex]."+collectionData.temp.otherLevel[levelIndex])
					                                                               : collectionData.compare.currentData[subTotalIndex] +  eval("convertInfo.base.data[dataIndex]."+collectionData.temp.otherLevel[levelIndex]);
			
		 });     	    		  
		 collectionData.compare.currentData[subTotalIndex] = (_.size(collectionData.temp.otherLevel) > 0) ? collectionData.compare.currentData[subTotalIndex] + eval("convertInfo.base.data[dataIndex]."+collectionData.temp.level[0])
					  																  : eval("convertInfo.base.data[dataIndex]."+collectionData.temp.level[0]);
   }
   
   
   //=========================================================
   // Json 데이터를 만들어 반환한다.
   //=========================================================
   function step_3_subTotal_makeJson(convertInfo,collectionData, subTotalIndex){
  	 	var addSubTotalLevel = '';
  	 	var isBreakOnIncludeCheck = false;
  	 	
  	    
  	 
     	 $.each( collectionData.temp.level, function(levelIndex){
     		var subTotalKey = eval("collectionData.temp.level[levelIndex]");
     		var subTotalValue = collectionData.temp.title[levelIndex];
     		 
    		
     		
     		// 조건에 맞는 데이터만 소계를 만든다.
     		if (_.isUndefined(convertInfo.subTotal[subTotalIndex].includeData) == false){
     			if (convertInfo.subTotal[subTotalIndex].includeData.length > 0){
         		 	if (convertInfo.subTotal[subTotalIndex].includeData[levelIndex].length > 0){
         				var includeText = convertInfo.subTotal[subTotalIndex].includeData[levelIndex];
         				if (_.contains(includeText, collectionData.text.setupRefData[subTotalIndex]) == false) {
         					isBreakOnIncludeCheck = true;
         					addSubTotalLevel = '';
         				}
         		 	} 
         		}
     		}
     		
     		
     		
     	    // 조건에 맞지 않는 데이터는 배제한다.
     		if (_.isUndefined(convertInfo.subTotal[subTotalIndex].excludeData) == false){
	     		if (convertInfo.subTotal[subTotalIndex].excludeData.length > 0){
	     		 	if (convertInfo.subTotal[subTotalIndex].excludeData[levelIndex].length > 0){
	     				var excludeText = convertInfo.subTotal[subTotalIndex].excludeData[levelIndex];
	     				if (_.contains(excludeText, collectionData.text.setupRefData[subTotalIndex])) {
	     					isBreakOnIncludeCheck = true;
	     					addSubTotalLevel = '';
	     				}
	     		 	} 
	     		}
     		}
     		
     		// ** 각 subtotal 의 level 의 첫번째 레벨의 값이 공백일때는 continue 
     		// excludeData " [ "" , [] ] 처럼 공백을 배제안해도 되지만, callback weight 에서 전체합이 틀어진다.
     		/*if (_.isEmpty(collectionData.text.setupRefData[subTotalIndex])){
     			isBreakOnIncludeCheck = true;
     			addSubTotalLevel = '';
     		}*/
     		
     		if (isBreakOnIncludeCheck) return false;
     
     		
     		// value 중에 * 가 있으면 실제 데이터로 치환한다.
     		if (subTotalValue.indexOf("*") != -1) {
     			subTotalValue = subTotalValue.substring(0,subTotalValue.indexOf("*")) + collectionData.text.setupRefData[subTotalIndex] + subTotalValue.substring(subTotalValue.indexOf("*")+1);
     		}	      	
			// 값이 같을경우 원본데이터가 숫자인지 문자인지 구분한다.
			if (subTotalValue == (collectionData.text.setupRefData[subTotalIndex] + "")){
				addSubTotalLevel += ',"'+ subTotalKey +'" : "' + subTotalValue+ '" '; 
				/*
				if (isNumber(collectionData.text.setupRefData[subTotalIndex])){
					addSubTotalLevel += ',"'+ subTotalKey +'" : ' + subTotalValue+ ' '; 
				} else {
					addSubTotalLevel += ',"'+ subTotalKey +'" : "' + subTotalValue+ '" '; 
				}
				*/
			} else {
				addSubTotalLevel += ',"'+ subTotalKey +'" : "' + subTotalValue+ '" '; 
			}
     		
     		
     	 });
     	 
     	 if (isBreakOnIncludeCheck == false)      	 
     	 	addSubTotalLevel = '{' + collectionData.temp.addSubTotalOtherLevel + addSubTotalLevel.substring(1) + '}';
  	       	 	
     	 return addSubTotalLevel;
   }
   
   //==============================================================
   // 데이터를 입력
   //==============================================================
   function step_4_insert_total_subtotal(convertInfo,orgGridJson){   
  	   // 소계의 position 에 대한 위치를 변경, top or bottom
	   var tmpTopRowType = [];
	   var tmpCloneRowType = [];
	   var tmpCloneData = [];
	   var tmpTopData = [];
	   // subtotal 의 position 을 바꾼다.
	   // ** convertInfo.base.data 의 index 와 convertInfo.rowType 의 index 는 같다.
	   $.each(convertInfo.rowType, function (rowIndex){
		   // top 에 해당하는 값을 뽑는다.
		   if (_.values(convertInfo.rowType[rowIndex])[0] == "S"){
			   if (convertInfo.rowType[rowIndex].position == "top"){
				   tmpTopRowType.push(convertInfo.rowType[rowIndex]);
				   tmpTopData.push(convertInfo.base.data[rowIndex]);
				   return true; // continue
			   }
		   }		   
		   tmpCloneRowType.push(convertInfo.rowType[rowIndex]);
		   tmpCloneData.push(convertInfo.base.data[rowIndex]);
	   });
	  
	   // top 으로 입력된 부분을 넣는다.
	   $.each(tmpTopRowType, function (topRowIndex){ 
		   
		   $.each(tmpCloneRowType, function (rowIndex){ 
			   if (_.values(tmpCloneRowType[rowIndex])[0] == "D"){
				   if (_.contains(tmpCloneRowType[rowIndex].uniqueGroup ,tmpTopRowType[topRowIndex].uniqueGroup)){
					   // 해당되는 값이 있다면
					   tmpCloneRowType.splice(rowIndex, 0,tmpTopRowType[topRowIndex]);
					   tmpCloneData.splice(rowIndex, 0,tmpTopData[topRowIndex]);
					   
					   return false; // break;
				   }
			   }
		   });
	   });
	   convertInfo.rowType = tmpCloneRowType;
	   convertInfo.base.data = tmpCloneData;
	   
	   
	   // row 를 기준으로 각각의 타입에 맞는 함수를 호출한다.	   
       // convertInfo.rowType 을 기준으로 해당 function 으로 이동
  	   $.each(convertInfo.rowType, function (rowIndex){   
  		   // Data 인경우
  		   switch(_.values(convertInfo.rowType[rowIndex])[0] ){
  		   		case "D" : 
  		   			step_4_1_apply_data_datacolumn(convertInfo,rowIndex);
  		   			break;
  		   		
  		   		case "S" :
  		   			step_4_2_apply_subtotal(convertInfo,rowIndex,orgGridJson);
  		   			break;
  		   		
  		   		case "T" :
  		   			step_4_2_apply_total(convertInfo,rowIndex,orgGridJson);
  		   			break;
  		   }
  	   });
   }
   
   //==============================================================
   // 데이터를 입력 , Total , SubTotal 을 제외한 Data 부문 입력
   //==============================================================   
   function step_4_1_apply_data_datacolumn(convertInfo,rowIndex){
	   
	   var rowJson = _.clone(convertInfo.base.data[rowIndex]); 

       $.each(rowJson, function(headerIndex){
    	// key 컬럼이라면 continue
    	  if (_.contains(convertInfo.base.keyByRef, headerIndex) ) return true;
    	 
    	  var data = rowJson[headerIndex]+"";
    	  
    	  if (_.isUndefined(data) == false){  		  
    		  if (_.isEmpty(data)){
    			  // 비어있는 경우
    			  rowJson[headerIndex] = convertInfo.base.emptyDataReplace;
    		  } else {
    			 if (isNumber(data)){
  	    			if (_.isString(data)) data = Number(data);
  	    			
  	    		    if (_.isUndefined(convertInfo.base.isConvertInteger) == false){
			    	    if (convertInfo.base.isConvertInteger){
			    		  // 정수표현을 소수점 붙여 무조건 표기
			    	 	   rowJson[headerIndex] = data.toFixed(convertInfo.base.digit);
			    	    } else {
			    		   // 정수표현을 그대로  
			    		   var strData = data + "";
			    		   if (strData.indexOf('.') > -1){
			    			  rowJson[headerIndex] = data.toFixed(convertInfo.base.digit);
			    		   } else {
			    			  rowJson[headerIndex] = data;				    		  	
			    		   }  	
			    	    }
			         } else {
			    	     rowJson[headerIndex] = data.toFixed(convertInfo.base.digit);
			         }
  	    		  }
    		  }  	  	    		  
	     } else {
		   rowJson[headerIndex] =   convertInfo.base.emptyDataReplace;
	     }
       });
       
       convertInfo.base.data[rowIndex] = rowJson;
   }
   
   //==============================================================
   // SubTotal Data 부문 입력
   //==============================================================  
   function step_4_2_apply_subtotal(convertInfo,rowIndex,orgGridJson){
	   var rowJson; 
	   var valueJson;
	   
	   // subtotallevel 이 없는 경우는 1 depth 만으로 소계를 만든경우
	   if (_.isEmpty(convertInfo.rowType[rowIndex].subtotallevel)){
		   rowJson = _.clone(convertInfo.base.data[rowIndex]); 
		   valueJson = _.where(orgGridJson, _.object(_.keys(rowJson),[ convertInfo.rowType[rowIndex].uniqueGroup ] ) );
	   } else {
		   rowJson = _.clone(convertInfo.base.data[rowIndex]); 
		   valueJson = _.where(orgGridJson, _.omit(rowJson,convertInfo.rowType[rowIndex].subtotallevel) );
	   }
	   
	   
	   $.each(convertInfo.subTotal, function(subTotalIndex){
		   // 설정한 level 과 같이 같다면
		   if (_.isEqual(convertInfo.subTotal[subTotalIndex].level , convertInfo.rowType[rowIndex].subtotalconfig) ) {
			   // valueByRef 값에 해당하는 ref 를 찾으면서 계산한다.
			   $.each(convertInfo.subTotal[subTotalIndex].valueByRef , function(refColumnIndex){
				   // 병합된 Cell 을 하나의 데이터로 처리한다면
				   var refDataGroup = [];
				   
				   // 키에 대한 값.
				   var subtotalKey = convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].ref;
				   var subtotalValue = 0;
				   var direction = "column";				   
				   
				   // direction 이 없다면 기본은 col 기준임.
				   if (_.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].direction) == false ){
					   direction = convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].direction;
				   }
				   
				   // 참조하는 값의 데이터만 뽑
				   // column 기준일때
				   if (direction == "column"){
					   // ref column 의 값만 refDataGroup 으로 따로 뽑음, ["10","20","30"] 형태의 1차원 배열
					   if (_.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].isMergeCellOneData) == false  ){
						   // isMergeCellOneData 설정이 있다면
						   if (convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].isMergeCellOneData){
							   // 병합이 되는 경우의 하나의 데이터로 처리하려고 할때
							   var tmpArrGroups = [];						   
							   var mergeKeys= convertInfo.rowType[rowIndex].subtotalconfig.concat( subtotalKey );
							   $.each(valueJson, function(valuJsonIndex){
								   if ( _.size(_.where(tmpArrGroups, _.pick(valueJson[valuJsonIndex],mergeKeys ))) == 0 ) {
									   tmpArrGroups.push(_.pick(valueJson[valuJsonIndex],mergeKeys ));  
								   }
							   });
							   refDataGroup.push(_.pluck(tmpArrGroups,subtotalKey ));
							   
						   } else {
							   refDataGroup.push(_.pluck(valueJson,subtotalKey));
						   }
					   } else {
						   refDataGroup.push(_.pluck(valueJson,subtotalKey ));
					   }
					   
				   } else {
				       // row 기준일때	   
					   // ref column 의 값만 refDataGroup 으로 따로 뽑음,2차원 배열
					   // TODO : 미개발 , _.pluck(valueJson,반복적인 ref 로 실행 )
					   // 형태는 { fixedCalc : "sum",     ref : "etc" , direction : "row" , excludeRef : ["lvl1","lvl2","lvl3","unit"]},
					   
				   }
				   
				   // direction column 일때
				   if (direction == "column"){
					   if (_.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].fixedCalc) == false ){
						   var fiexedCalc = convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].fixedCalc;
						   if (fiexedCalc == "sum" || fiexedCalc == "average"){						   
							   subtotalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) + Number(num); }, 0);
							   //if (_.isString(sum)) sum = Number(sum);
							   if (fiexedCalc == "average"){
								   subtotalValue = subtotalValue / _.compact(refDataGroup[0]).length;
							   }
						   } else if ( fiexedCalc == "max"){
							   subtotalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) > Number(num) ? Number(memo) : Number(num); }, 0);						   
						   } else if ( fiexedCalc == "min"){
							   // 최소값일때는 초기값을 기본값으로 입력
							   if (_.isUndefined(refDataGroup[0][0]) == false)
								   subtotalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) > Number(num) ? Number(num) : Number(memo); }, refDataGroup[0][0]);
							   else
								   subtotalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) > Number(num) ? Number(num) : Number(memo); }, 0);
						   } else if ( fiexedCalc == "count"){
							   subtotalValue = _.compact(refDataGroup[0]).length;
						   }
					   }
					   
					   // userCalc 인 경우
					   if (_.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].userCalc) == false  ){
						   // User CallBack function
						   // groupData 는 해당 소계 그룹에 해당하는 데이터 배열
						   // totalData 는 전체에 해당하는 데이터 배열
						   var keyCollection = { groupData : [] , totalData : [] };	
						   						   
						   var isUsingMergeRef = _.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].mergeRef);
						   
						   // groupRef 가 있다면
						   if (_.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].groupRef) == false  ){
							  
							   $.each( convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].groupRef, function(groupRefIndex){
								   
								   var groupRefKeys = convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].groupRef[groupRefIndex];
								   
								   // 병합에 대한 Cell 이 있다면
								   if (isUsingMergeRef == false  ){
									   // each 문의 groupRef[groupRefIndex] 가 mergeRef 라면
									   if (_.contains(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].mergeRef , groupRefKeys)){
										  
										   var tmpArrGroups = [];						   
										   var mergeKeys= convertInfo.rowType[rowIndex].subtotalconfig.concat( groupRefKeys );
										   $.each(valueJson, function(valuJsonIndex){
											   if ( _.size(_.where(tmpArrGroups, _.pick(valueJson[valuJsonIndex],mergeKeys ))) == 0 ) {
												   tmpArrGroups.push(_.pick(valueJson[valuJsonIndex],mergeKeys ));  
											   }
										   });
										   keyCollection.groupData.push(_.pluck(tmpArrGroups,groupRefKeys));
										   
									   } else {
										   keyCollection.groupData.push(_.pluck(valueJson,groupRefKeys ));   
									   }
								   } else {
									   
									   keyCollection.groupData.push(_.pluck(valueJson,groupRefKeys ));  
								   }
								   
							   });
						   }
						   
						   if (_.isUndefined(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].totalRef) == false  ){
							   $.each( convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].totalRef, function(totalRefIndex){
								   
								   var totalRefKeys = convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].totalRef[totalRefIndex];
								   
								   if (isUsingMergeRef == false  ){
									   // each 문의 groupRef[groupRefIndex] 가 mergeRef 라면
									   if (_.contains(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].mergeRef , totalRefKeys)){
										  
										   var tmpArrGroups = [];						   
										   var mergeKeys= convertInfo.rowType[rowIndex].subtotalconfig.concat( totalRefKeys );
										   $.each(orgGridJson, function(valuJsonIndex){
											   if ( _.size(_.where(tmpArrGroups, _.pick(orgGridJson[valuJsonIndex],mergeKeys ))) == 0 ) {
												   tmpArrGroups.push(_.pick(orgGridJson[valuJsonIndex],mergeKeys ));  
											   }
										   });
										   keyCollection.totalData.push(_.pluck(tmpArrGroups,totalRefKeys ));
										   
									   } else {
										   keyCollection.totalData.push(_.pluck(orgGridJson,totalRefKeys ));   
									   }
								   } else {
									   
									   keyCollection.totalData.push(_.pluck(orgGridJson,totalRefKeys ));
								   }
								   
								  
							   });
						   }
						   
						   subtotalValue = eval(convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].userCalc + "(keyCollection.groupData,keyCollection.totalData)");
							
						   subtotalKey = convertInfo.subTotal[subTotalIndex].valueByRef[refColumnIndex].position; 
						 
					   }
					   
					   var valueData = "";
					   // 소수점에 대한 표기
					   if (_.isUndefined(convertInfo.base.isConvertInteger) == false){
				    		if (convertInfo.base.isConvertInteger){
				    			// 정수표현을 소수점 붙여 무조건 표기
					    		valueData = '{"'+subtotalKey+'" : "'+ subtotalValue.toFixed(convertInfo.base.digit) +'"}';
				    		} else {
				    			// 정수표현을 그대로  
				    			var strSum = subtotalValue + "";
				    			if (strSum.indexOf('.') > -1){
				    				valueData = '{"'+subtotalKey+'" : "'+ subtotalValue.toFixed(convertInfo.base.digit) +'"}';
				    			} else {
				    				valueData = '{"'+subtotalKey+'" : "'+ subtotalValue +'"}';
				    			}	
				    		}
				        } else {
				    		 valueData = '{"'+subtotalKey+'" : "'+ subtotalValue.toFixed(convertInfo.base.digit) +'"}';
				        } 
					  
					    if (_.isEmpty(valueData) == false)  _.extend(rowJson, $.parseJSON(valueData));
				        //console.log(valueJson,refDataGroup);
				    } else {
				    	// direction row 일때
				    	// TODO : 미개발				    	
				    }
			   });			   
			   return false; //break;
		   }
	   });
	   	   
	   //console.log(valueJson, convertInfo.rowType[rowIndex]); 
       convertInfo.base.data[rowIndex] = rowJson;	  
   }
   
   
   //==============================================================
   // Total Data 부문 입력
   //==============================================================  
   function step_4_2_apply_total(convertInfo,rowIndex,orgGridJson){
	   var rowJson = _.clone(convertInfo.base.data[rowIndex]); 
	 	
	   var tmpTotalTopBottom = [];
	   
	   if (convertInfo.rowType[rowIndex].position == "top"){
		   tmpTotalTopBottom = convertInfo.total.top;
	   } else if (convertInfo.rowType[rowIndex].position == "bottom"){
		   tmpTotalTopBottom = convertInfo.total.bottom;
	   }   
			   
	   if (_.isUndefined(tmpTotalTopBottom) == false){
	       // total top 인 경우
		   $.each(tmpTotalTopBottom, function(topBottomIndex){
			   // 이미 생성을 했다면 다음 index 로 넘어간다.
			   if (_.isUndefined( tmpTotalTopBottom[topBottomIndex].isBinded) == false) return true; // continue;
			   
			   $.each(tmpTotalTopBottom[topBottomIndex].valueByRef , function(refColumnIndex){
				   var refDataGroup = [];
				   
				   var totalKey = tmpTotalTopBottom[topBottomIndex].valueByRef[refColumnIndex].ref;
				   var totalValue = 0;
				   
				   // 병합에 대한 처리
				   if (_.isUndefined( tmpTotalTopBottom[topBottomIndex].valueByRef[refColumnIndex].isMergeCellOneData) == false  ){
					   // isMergeCellOneData 설정이 있다면
					   if (tmpTotalTopBottom[topBottomIndex].valueByRef[refColumnIndex].isMergeCellOneData){
						   // 병합이 되는 경우의 하나의 데이터로 처리하려고 할때
						   var tmpArrGroups = [];						   
						   var mergeKeys= convertInfo.base.keyByRef.concat( totalKey );
						   $.each(orgGridJson, function(valuJsonIndex){
							   if ( _.size(_.where(tmpArrGroups, _.pick(orgGridJson[valuJsonIndex],mergeKeys ))) == 0 ) {
								   tmpArrGroups.push(_.pick(orgGridJson[valuJsonIndex],mergeKeys ));  
							   }
						   });
						   
						   refDataGroup.push(_.pluck(tmpArrGroups,totalKey ));
						   
					   } else {
						   refDataGroup.push(_.pluck(orgGridJson,totalKey ));
					   }
				   } else {
					   refDataGroup.push(_.pluck(orgGridJson,totalKey ));
				   }
				   
				   
				   if (_.isUndefined(tmpTotalTopBottom[topBottomIndex].valueByRef[refColumnIndex].fixedCalc) == false ){
					   var fiexedCalc = tmpTotalTopBottom[topBottomIndex].valueByRef[refColumnIndex].fixedCalc;
					   
					   if (fiexedCalc == "sum" || fiexedCalc == "average"){						   
						   totalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) + Number(num); }, 0);
						   //if (_.isString(sum)) sum = Number(sum);
						   if (fiexedCalc == "average"){
							   totalValue = totalValue / _.compact(refDataGroup[0]).length;
						   }
					   } else if (fiexedCalc == "max"){
						   totalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) > Number(num) ? Number(memo) : Number(num); }, 0);						   
					   } else if ( fiexedCalc == "min"){
						   // 최소값일때는 초기값을 기본값으로 입력
						   if (_.isUndefined(refDataGroup[0][0]) == false)
							   totalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) > Number(num) ? Number(num) : Number(memo); }, refDataGroup[0][0]);
						   else
							   totalValue = _.reduce(_.compact(refDataGroup[0]), function(memo, num){ return Number(memo) > Number(num) ? Number(num) : Number(memo); }, 0);
					   } else if ( fiexedCalc == "count"){
						   totalValue = _.compact(refDataGroup[0]).length;
							
					   }
				   }
				   
				   
				   var valueData = "";
				   // 소수점에 대한 표기
				   if (_.isUndefined(convertInfo.base.isConvertInteger) == false){
			    		if (convertInfo.base.isConvertInteger){
			    			// 정수표현을 소수점 붙여 무조건 표기
				    		valueData = '{"'+totalKey+'" : "'+ totalValue.toFixed(convertInfo.base.digit) +'"}';
			    		} else {
			    			// 정수표현을 그대로  
			    			var strSum = totalValue + "";
			    			if (strSum.indexOf('.') > -1){
			    				valueData = '{"'+totalKey+'" : "'+ totalValue.toFixed(convertInfo.base.digit) +'"}';
			    			} else {
			    				valueData = '{"'+totalKey+'" : "'+ totalValue +'"}';
			    			}	
			    		}
			        } else {
			    		 valueData = '{"'+totalKey+'" : "'+ totalValue.toFixed(convertInfo.base.digit) +'"}';
			        } 
				  
				    if (_.isEmpty(valueData) == false)  _.extend(rowJson, $.parseJSON(valueData));					   
			   });
			   
			   _.extend(tmpTotalTopBottom[topBottomIndex],$.parseJSON(' {"isBinded":"y"} '));
			   return false; // break;
	       });
	   }
		   	   
       convertInfo.base.data[rowIndex] = rowJson;	  
	   
   }   
   
   // utiltiy function 
   // str = "10" 을 입력해도 숫자로 true 로 리턴함.
   // _.isNumber(str) 은 false 임.
   function isNumber(str) {
	    var pattern = /^\d+$/;
	    return pattern.test(str);  // returns a boolean
   }
 
})(SBTotal || (SBTotal = {}));