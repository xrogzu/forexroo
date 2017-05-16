function tooltip(id, title) {
	$('#' + id).attr('title', title).tooltipster({
		theme : 'tooltipster-light',
		trigger : 'click',
		side : [ 'right', 'bottom' ]
	}).tooltipster('open');
}