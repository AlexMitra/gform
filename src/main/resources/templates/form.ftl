<!DOCTYPE html>
<html lang="en_US">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Quicksand:500" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:500" rel="stylesheet">

    <link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="css/font-awesome.min.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="css/main-style.css" type="text/css">

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/formValidation.min.js"></script>
    <script src="js/framework/bootstrap.min.js"></script>
    <script src="js/addForm.js"></script>
    <script src="js/removeForm.js"></script>

    <title>Kalilaska Forms</title>
</head>

<body>
    <!--    add form dialog-->
    <div class="modal fade" id="add-form-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">New Form</h4>
                </div>

                <div class="form-container">
                    <form id="add-question-form" method="POST" action="add-form.html" enctype="utf8">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Form name" name="formName">
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" placeholder="Description" rows="3" name="formDescription"></textarea>
                        </div>
                        <div class="horizontal-line"></div>

                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Question" name="formQuestion">
                        </div>
                        
                        <div class="form-group">
                            <div class="radio">
                                <label>
                            <input name="formAnswerType" type="radio" value="radiobutton"/>
                            <span class="label-body">radiobuttons</span>
                          </label>
                            </div>
                            <div class="radio">
                                <label>
                            <input name="formAnswerType" type="radio" value="checkbox"/>
                            <span class="label-body">checkboxes</span>
                          </label>
                            </div>
                        </div>

                        <div class="horizontal-line"></div>

                        <div class="form-group answer-input" id="add-form-answer-container1">
                            <input type="text" class="form-control" id="add-form-answer1" placeholder="answer1" name="formAnswer1">
                        </div>
                        <div class="checkbox answer-right-input" id="add-form-answer-right-container1">
                            <label>
							    <input type="checkbox" name="formAnswerRight1" value="true">
							</label>
                        </div>
                        <div class="form-group answer-input" id="add-form-answer-container2">
                            <input type="text" class="form-control" id="add-form-answer2" placeholder="answer2" name="formAnswer2">
                        </div>
                        <div class="checkbox answer-right-input" id="add-form-answer-right-container2">
                            <label>
							    <input type="checkbox" name="formAnswerRight2" value="true">
							</label>
                        </div>
                        <div class="form-group answer-input" id="add-form-answer-container3">
                            <input type="text" class="form-control" id="add-form-answer3" placeholder="answer3" name="formAnswer3">
                        </div>
                        <div class="checkbox answer-right-input" id="add-form-answer-right-container3">
                            <label>
							    <input type="checkbox" name="formAnswerRight3" value="true">
							</label>
                        </div>

                        <div id="add-remove-answer-button-block" class="add-form-add-answer-button-container">
                            <i class="fa fa-2x fa-plus-circle add-remove-answer-button" aria-hidden="true" onclick="addForm.addAnswer()"></i>
                            <i class="fa fa-2x fa-minus-circle add-remove-answer-button" aria-hidden="true" onclick="addForm.removeAnswer()"></i>
                        </div>

                        <div id="add-form-save-form-button" class="add-form-submit-button-container">
                            <button type="submit" class="btn btn-danger">Save form</button>
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    
    <script>
        $(document).ready(function() {
            $('#add-question-form').formValidation({
                framework: 'bootstrap',
                icon: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                	formName: {
                        validators: {
                            notEmpty: {
                                message: 'Form name is required'
                            },
                            stringLength: {
                                min: 6,
                                max: 30
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    },
                    formQuestion: {
                        validators: {
                            notEmpty: {
                                message: 'Question is required'
                            },
                            stringLength: {
                                min: 9
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    },
                    formAnswerType: {
                        validators: {
                            notEmpty: {
                                message: 'Answer type is required'
                            }
                        }
                    },
                    formAnswer1: {
                        validators: {
                            notEmpty: {
                                message: 'Answer is required'
                            },
                            stringLength: {
                                min: 6,
                                max: 30
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    },
                    formAnswer2: {
                        validators: {
                            notEmpty: {
                                message: 'Answer is required'
                            },
                            stringLength: {
                                min: 6,
                                max: 30
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    },
                    formAnswer3: {
                        validators: {
                            notEmpty: {
                                message: 'Answer is required'
                            },
                            stringLength: {
                                min: 6,
                                max: 30
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    },
                    formAnswer4: {
                        validators: {
                            notEmpty: {
                                message: 'Answer is required'
                            },
                            stringLength: {
                                min: 6,
                                max: 30
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    },
                    formAnswer5: {
                        validators: {
                            notEmpty: {
                                message: 'Answer is required'
                            },
                            stringLength: {
                                min: 6,
                                max: 30
                            },
                            regexp: {
                                regexp: /^[ a-zA-Z0-9а-яА-ЯёЁ]+$/
                            }
                        }
                    }
                }
            });
        });
    </script>

    <!-- delete form dialog-->
    <div class="modal fade" id="form-modal-delete-form" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 id="delete-form-dialog-title" class="modal-title">Delete </h4>
                </div>

                <div class="form-container">
                    <h4>Are you sure?</h4>

                    <form method="POST" action="delete-form.html" enctype="utf8">
                    	<input type="text" id="delete-form-id-input" name="formIdForDelete" hidden value="">
                        <div id="add-form-delete-form-button">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <!-- saved form dialog-->
    <#list viewBean.getFormList() as formItem>
    <div class="modal fade" id="form-modal-${formItem.getId()}" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">${formItem.getName()}</h4>
                </div>

                <div class="form-container">

                    <p class="form-description">
	                    <#if formItem.getDescription()??>
						   ${formItem.getDescription()}
						</#if>                    
                    </p>

                    <div class="horizontal-line"></div>

                    <h4>${formItem.getQuestion().getText()}</h4>
                    <form id="question-form-${formItem.getQuestion().getId()}">
                    	<#list formItem.getQuestion().getAnswerList() as answer>
                    		<#if formItem.getQuestion().getAnswerType().getTypeName() == 'radiobutton'>
		                        <div class="radio">
		                            <label>
		                            <input type="radio" name="answerType" id="add-form-answer-type-radiobutton" value="answerTypeRadiobutton">
		                            ${answer.getText()}
		                          </label>
		                        </div>
	                        <#elseif formItem.getQuestion().getAnswerType().getTypeName() == 'checkbox'>
		                        <div class="checkbox">
								  <label>
								    <input type="checkbox" value="">
								    ${answer.getText()}
								  </label>
								</div>
	                        </#if>
						</#list>
                        <div class="horizontal-line"></div>

                        <div id="question-form--check-answer-button">
                            <button type="submit" class="btn btn-danger">Check answer</button>
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    </#list>


    <nav class="header-container">
        <div class="site-name-container">
            <span>Kalilaska Forms</span>
        </div>
        <div class="search-panel-container">            
             <input type="text" class="search-panel-input" onkeyup="" placeholder="Search">            
        </div>
    </nav>


    <main class="body-container clearfix">
        <div class="all-form-item-container">
			<#list viewBean.getFormList() as formItem>
	            <div class="form-item-container">
	                <div class="form-item-header-container">
	                    <i class="fa fa-times form-item-close-button" aria-hidden="true" data-toggle="modal" data-target="#form-modal-delete-form" onclick="removeForm.writeTitle('${formItem.getName()}', ${formItem.getId()})"></i>
	                </div>
	                <div class="form-item-form-link" data-toggle="modal" data-target="#form-modal-${formItem.getId()}">
	                    <div class="form-item-body-container"></div>
	                    <div class="form-item-footer-container">
	                        <div class="form-item-name">
	                            <span class="form-item-name-text">${formItem.getName()}</span>
	                        </div>
	                        <div class="form-item-date"><span class="form-tem-date-text">Created at ${formItem.getCreationDate()}</span></div>
	                    </div>
	                </div>
	            </div>
            </#list>
            
        </div>

        <div class="add-form-button-container" data-toggle="modal" data-target="#add-form-modal">
            <i class="fa fa-5x fa-plus-circle add-form-button" aria-hidden="true"></i>
        </div>
    </main>


</body>

</html>