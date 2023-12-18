function sendAcceptEmail(email) {
    fetch('/acceptEmailEndpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email, action: 'accept' }),
    })
    .then(response => {
        if (response.ok) {
            alert('Acceptance email sent successfully!');
        } else {
            throw new Error('Failed to send acceptance email.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to send acceptance email.');
    });
}

function sendRejectEmail(email) {
    fetch('/rejectEmailEndpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email, action: 'reject' }),
    })
    .then(response => {
        if (response.ok) {
            alert('Rejection email sent successfully!');
        } else {
            throw new Error('Failed to send rejection email.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Failed to send rejection email.');
    });
}
