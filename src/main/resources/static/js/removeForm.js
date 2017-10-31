var removeForm = {
    writeTitle: function (formName, id) {
        var title = document.getElementById("delete-form-dialog-title");
        var titleContent = title.innerHTML;
        
        titleContent = "Delete " + formName;
        title.innerHTML = titleContent;

        document.getElementById("delete-form-id-input").value = id;
    }
}
