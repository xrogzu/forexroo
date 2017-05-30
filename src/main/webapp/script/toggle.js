$(document).ready(function() {
    $("input[type=radio].toggle").each(function() {
        this.toggle = this.checked;
    });
    $("input[type=radio].toggle").click(function() {
        if (this.toggle) {
            this.checked = false;
        }
        this.toggle = this.checked;
    });
});