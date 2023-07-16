function submitButton() {
    let employeeID = document.getElementById("idInput").value;
    window.location.href = window.location.href + "users/" + employeeID + "/searchForUser";
}