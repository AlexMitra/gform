var addForm = {
    answerCount: 3,

    addAnswer: function () {
        if (this.answerCount < 5) {
            this.answerCount++;

            var form = document.getElementById("add-question-form");

            this.removeDownBlock();

            var formContent = form.innerHTML;
            formContent += "<div class='form-group answer-input' id='add-form-answer-container" + this.answerCount +
                "'><input type='text' class='form-control' id='add-form-answer" +
                this.answerCount + "' placeholder='answer" + this.answerCount + "' name='add_form_answer" + this.answerCount + "'></div>";
            
            formContent += "<div class='checkbox answer-right-input' id='add-form-answer-right-container" + this.answerCount + "'>" + 
            	"<label><input type='checkbox' name='formAnswerRight" + this.answerCount + "' value='true'></label>" + 
            	"</div>";

            form.innerHTML = formContent;

            this.addDownBlock();
        }
    },

    removeAnswer: function () {
        if (this.answerCount > 1) {
            var form = document.getElementById("add-question-form");

            var lastAnswer = document.getElementById("add-form-answer-container" + this.answerCount);
            var lastAnswerRight = document.getElementById("add-form-answer-right-container" + this.answerCount);
            var form = document.getElementById("add-question-form");

            form.removeChild(lastAnswer);
            form.removeChild(lastAnswerRight);
            this.removeDownBlock();

            this.answerCount--;
            this.addDownBlock();
        }
    },

    removeDownBlock: function () {
        var form = document.getElementById("add-question-form");
        var addButton = document.getElementById("add-remove-answer-button-block");
        var saveFormButton = document.getElementById("add-form-save-form-button");
        form.removeChild(addButton);
        form.removeChild(saveFormButton);
    },

    addDownBlock: function () {
        var form = document.getElementById("add-question-form");
        var formContent = form.innerHTML;

        formContent += "<div id='add-remove-answer-button-block' class='add-form-add-answer-button-container'>" +
            "<i class='fa fa-2x fa-plus-circle add-remove-answer-button' aria-hidden='true' onclick='addForm.addAnswer()'></i>" +
            "<i class='fa fa-2x fa-minus-circle add-remove-answer-button' aria-hidden='true' onclick='addForm.removeAnswer()'></i>" +
            "</div>";

        formContent += "<div id='add-form-save-form-button' class='add-form-submit-button-container'>" +
            "<button type='submit' class='btn btn-danger'>Save form</button>" +
            "</div>";

        form.innerHTML = formContent;
    }
}
