function addFacebookMarketPlaceEntry() {
    // Container where Facebook Marketplace entries are appended
    const container = document.getElementById('facebook-marketplace-container');

    // Get the number of current entries to set the new index
    const index = container.children.length;

    // Create a new Facebook Marketplace entry
    const entry = document.createElement('div');
    entry.className = 'facebook-marketplace-entry mb-3';
    entry.innerHTML = `
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="vehicle">Vehicle:</label>
                <input type="text" class="form-control" name="facebookMarketPlace[${index}].vehicle" required data-toggle="tooltip" data-placement="top">
            </div>
            <div class="form-group col-md-3">
                <label for="make">Make:</label>
                <input type="text" class="form-control" name="facebookMarketPlace[${index}].make" required data-toggle="tooltip" data-placement="top">
            </div>
            <div class="form-group col-md-3">
                <label for="model">Model:</label>
                <input type="text" class="form-control" name="facebookMarketPlace[${index}].model" required data-toggle="tooltip" data-placement="top">
            </div>
            <div class="form-group col-md-3">
                <label for="stockNumber">Stock Number:</label>
                <input type="text" class="form-control" name="facebookMarketPlace[${index}].stockNumber" required data-toggle="tooltip" data-placement="top">
            </div>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeFacebookMarketPlaceEntry(this)">Remove Entry</button>
    `;

    // Append the new entry to the container
    container.appendChild(entry);
}

function removeFacebookMarketPlaceEntry(button) {
    // Remove the parent element (facebook-marketplace-entry) of the clicked remove button
    button.parentElement.remove();
}

function addCrmProspectEntry() {
    // Container where CRM Prospects entries are appended
    const container = document.getElementById('crm-prospects-container');

    // Get the number of current entries to set the new index
    const index = container.children.length;

    // Create a new CRM Prospect entry
    const entry = document.createElement('div');
    entry.className = 'crm-prospect-entry mb-3';
    entry.innerHTML = `
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="prospectFirstName">First Name:</label>
                <input type="text" class="form-control" name="crmProspects[${index}].prospectFirstName" required data-toggle="tooltip" data-placement="top">
            </div>
            <div class="form-group col-md-4">
                <label for="prospectLastName">Last Name:</label>
                <input type="text" class="form-control" name="crmProspects[${index}].prospectLastName" required data-toggle="tooltip" data-placement="top">
            </div>
            <div class="form-group col-md-4">
                <label for="crmCustomerNumber">CRM Customer Number:</label>
                <input type="number" class="form-control" name="crmProspects[${index}].crmCustomerNumber" min="0" max="9999999" required data-toggle="tooltip" data-placement="top">
            </div>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeCrmProspectEntry(this)">Remove Entry</button>
    `;

    // Append the new entry to the container
    container.appendChild(entry);
}

function removeCrmProspectEntry(button) {
    // Remove the parent element (crm-prospect-entry) of the clicked remove button
    button.parentElement.remove();
}

document.addEventListener('DOMContentLoaded', function() {
    // Initialize Bootstrap tooltips
    $('[data-toggle="tooltip"]').tooltip();

    // Form submission event
    const form = document.querySelector('form');
    form.addEventListener('submit', function(event) {
        // Prevent the form from submitting
        event.preventDefault();

        // Clear previous validation
        clearValidation();

        // Validate the form
        let isValid = validateForm();

        // If the form is valid, submit it
        if (isValid) {
            form.submit();
        }
    });
});

// Function to clear previous validation
function clearValidation() {
    const inputs = document.querySelectorAll('input, select, textarea');
    inputs.forEach(input => {
        input.classList.remove('is-invalid');
        $(input).tooltip('dispose');
    });
}

// Function to validate the form
function validateForm() {
    let isValid = true;
    const inputs = document.querySelectorAll('input[required], select[required], textarea[required]');

    inputs.forEach(input => {
        if (!input.value.trim()) {
            isValid = false;
            // Add Bootstrap is-invalid class
            input.classList.add('is-invalid');

            // Set tooltip content
            input.setAttribute('data-toggle', 'tooltip');
            input.setAttribute('data-placement', 'top');
            input.setAttribute('title', 'This field is required.');

            // Initialize Bootstrap tooltip
            $(input).tooltip('show');

            // Focus on the first invalid field
            if (isValid) {
                input.focus();
            }
        }
    });

    return isValid;
}
