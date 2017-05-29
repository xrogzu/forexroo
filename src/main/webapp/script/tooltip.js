function tooltip(id, title) {
    $('#' + id).tooltipster({
        theme: 'tooltipster-light',
        trigger: 'click',
        side: ['right', 'bottom']
    }).tooltipster('content', title).tooltipster('open');
}