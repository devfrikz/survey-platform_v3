function addVehicle() {
    // Container where vehicle entries are appended
    const container = document.getElementById('vehicle-container');

    // Obtiene el número de elementos actuales para establecer el nuevo índice
    const index = container.children.length;

    // Create a new vehicle entry
    const vehicleEntry = document.createElement('div');
    vehicleEntry.className = 'vehicle-entry mt-4';
    vehicleEntry.innerHTML = `
        <div class="form-group">
            <label>Name</label>
            <div class="row">
                <div class="col-md-6">
                    <input type="text" name="vehicles[${index}].name"
                           class="form-control" placeholder="First" required data-toggle="tooltip"
                           data-placement="top">
                </div>
                <div class="col-md-6">
                    <input type="text" name="vehicles[${index}].lastName"class="form-control"
                           placeholder="Last" required data-toggle="tooltip" data-placement="top">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Vehicle</label>
            <input type="text" name="vehicles[${index}].vehicle" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Time</label>
            <div class="row">
                <div class="col-md-4">
                    <input type="number" name="vehicles[${index}].hour" class="form-control" min="1" max="12" placeholder="Hour" required>
                </div>
                <div class="col-md-4">
                    <input type="number" name="vehicles[${index}].minute" class="form-control" min="0" max="59" placeholder="Minute" required>
                </div>
                <div class="col-md-4">
                    <select name="vehicles[${index}].amPm" class="form-control" required>
                        <option value="AM">AM</option>
                        <option value="PM">PM</option>
                    </select>
                </div>
            </div>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeVehicle(this)">Remove Vehicle</button>
    `;

    // Append the new vehicle entry to the container
    container.appendChild(vehicleEntry);
}

function removeVehicle(button) {
    // Remove the parent element (vehicle-entry) of the clicked remove button
    button.parentElement.remove();
}

function addShowroomVisit() {
    // Container where showroom visit entries are appended
    const container = document.getElementById('showroom-visit-container');

    // Get the number of current showroom visits to set the new index
    const index = container.children.length;

    // Create a new showroom visit entry
    const visitEntry = document.createElement('div');
    visitEntry.className = 'showroom-visit-entry mt-4';
    visitEntry.innerHTML = `
        <div class="form-group">
            <label>Name</label>
            <div class="row">
                <div class="col-md-6">
                    <input type="text" name="showroomVisits[${index}].visitFirstName" class="form-control" placeholder="First" required>
                </div>
                <div class="col-md-6">
                    <input type="text" name="showroomVisits[${index}].visitLastName" class="form-control" placeholder="Last" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="visitVehicle">Vehicle</label>
            <input type="text" name="showroomVisits[${index}].visitVehicle" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="dealRequirement">What will it take to make the deal?</label>
            <input type="text" name="showroomVisits[${index}].dealRequirement" class="form-control" required>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeShowroomVisit(this)">Remove Visit</button>
    `;

    // Append the new showroom visit entry to the container
    container.appendChild(visitEntry);
}

function removeShowroomVisit(button) {
    // Remove the parent element (showroom-visit-entry) of the clicked remove button
    button.parentElement.remove();
}

function addFbMarketplaceVehicle() {
    // Container where Facebook Marketplace vehicle entries are appended
    const container = document.getElementById('fb-marketplace-container');

    // Get the number of current Facebook Marketplace vehicles to set the new index
    const index = container.children.length;

    // Create a new Facebook Marketplace vehicle entry
    const vehicleEntry = document.createElement('div');
    vehicleEntry.className = 'fb-marketplace-entry mt-4';
    vehicleEntry.innerHTML = `
        <div class="form-group">
            <label for="fbStockNumber">Stock Number</label>
            <input type="text" name="fbMarketplaceVehicles[${index}].fbStockNumber" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="fbLink">FB Marketplace Link</label>
            <input type="url" name="fbMarketplaceVehicles[${index}].fbLink" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="fbVehicleType">Vehicle Type</label>
            <input type="text" name="fbMarketplaceVehicles[${index}].fbVehicleType" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="fbListingPrice">Listing Price</label>
            <input type="text" name="fbMarketplaceVehicles[${index}].fbListingPrice" class="form-control" required>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeFbMarketplaceVehicle(this)">Remove Vehicle</button>
    `;

    // Append the new vehicle entry to the container
    container.appendChild(vehicleEntry);
}

function removeFbMarketplaceVehicle(button) {
    // Remove the parent element (fb-marketplace-entry) of the clicked remove button
    button.parentElement.remove();
}

function addTradeIn() {
    // Container where Trade-in entries are appended
    const container = document.getElementById('trade-in-container');

    // Get the number of current Trade-ins to set the new index
    const index = container.children.length;

    // Create a new Trade-in entry
    const tradeInEntry = document.createElement('div');
    tradeInEntry.className = 'trade-in-entry mt-4';
    tradeInEntry.innerHTML = `
        <div class="form-group">
            <label for="tradeInYear">Year</label>
            <input type="number" name="tradeIns[${index}].tradeInYear" class="form-control" min="0" max="9999" required>
        </div>
        <div class="form-group">
            <label for="tradeInMake">Make</label>
            <input type="text" name="tradeIns[${index}].tradeInMake" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="tradeInModel">Model</label>
            <input type="text" name="tradeIns[${index}].tradeInModel" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="tradeInMileage">Mileage</label>
            <input type="number" name="tradeIns[${index}].tradeInMileage" class="form-control" min="0" max="9999999" step="any" required>
        </div>
        <div class="form-group">
            <label for="tradeInStockNumber">Stock number</label>
            <input type="text" name="tradeIns[${index}].tradeInStockNumber" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="tradeInDateAcquired">Date acquired</label>
            <input type="text" name="tradeIns[${index}].tradeInDateAcquired" class="form-control" maxlength="10" required>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeTradeIn(this)">Remove Trade-in</button>
    `;

    // Append the new Trade-in entry to the container
    container.appendChild(tradeInEntry);
}

function removeTradeIn(button) {
    // Remove the parent element (trade-in-entry) of the clicked remove button
    button.parentElement.remove();
}

function addReferral() {
    // Container where referral entries are appended
    const container = document.getElementById('referral-container');

    // Get the number of current referrals to set the new index
    const index = container.children.length;

    // Create a new referral entry
    const referralEntry = document.createElement('div');
    referralEntry.className = 'referral-entry mt-4';
    referralEntry.innerHTML = `
        <div class="form-group">
            <label>Name</label>
            <div class="row">
                <div class="col-md-6">
                    <input type="text" name="referrals[${index}].referralFirstName" class="form-control" placeholder="First" required>
                </div>
                <div class="col-md-6">
                    <input type="text" name="referrals[${index}].referralLastName" class="form-control" placeholder="Last" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="referralReason">Reason for contact</label>
            <select name="referrals[${index}].referralReason" class="form-control" required>
                <option value="introduction">Introduction</option>
                <option value="set-up-appointment">Set up appointment</option>
            </select>
        </div>
        <!-- Remove button -->
        <button type="button" class="btn btn-danger mt-2" onclick="removeReferral(this)">Remove Referral</button>
    `;

    // Append the new referral entry to the container
    container.appendChild(referralEntry);
}

function removeReferral(button) {
    // Remove the parent element (referral-entry) of the clicked remove button
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
