function toggleSidebar() {
    var sidebar = document.getElementById('sidebar');
    var content = document.querySelector('.content');
    var toggle = document.querySelector('.sidebar-toggle');
    sidebar.classList.toggle('collapsed');
    content.classList.toggle('collapsed');
    toggle.style.left = sidebar.classList.contains('collapsed') ? '80px' : '260px';
}

function toggleForm(formId, username = '', displayName = '', email = '', address = '', mobile = '', others = '', image = '', age = '') {
    const viewForm = document.getElementById('viewPatientDetailForm');

    [viewForm].forEach(form => form.classList.remove('active'));

    switch (formId) {
        case 'view':
            viewForm.classList.add('active');
            document.getElementById('viewUsername').value = username;
            document.getElementById('viewDisplayName').value = displayName;
            document.getElementById('viewEmail').value = email;
            document.getElementById('viewAddress').value = address;
            document.getElementById('viewMobile').value = mobile;
            document.getElementById('viewOthers').value = others;
            document.getElementById('viewImage').src = image;
            document.getElementById('viewAge').value = age;
            break;
}
}

function closeForm(formId) {
    document.getElementById(formId).classList.remove('active');
}

function submitViewPatientForm() {
    document.getElementById('viewPatientForm').submit();
}

function submitViewMedicalAppointmentListForm() {
    document.getElementById('viewMedicalAppointmentForm').submit();
}
function submitViewMedicalAppointmentListFormForNurse() {
    document.getElementById('viewMedicalAppointmentFormForNurse').submit();
}
function submitViewMedicalAppointmentHistoryListForm() {
    document.getElementById('viewMedicalAppointmentHistoryForm').submit();
}
