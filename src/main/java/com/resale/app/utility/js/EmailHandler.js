function sendAcceptEmail(email) {
    console.log('sendAcceptEmail called with email:', email);
    fetch('/email/accept', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email }),
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch((error) => console.error('Error:', error))
}

function sendRejectEmail(email) {
    console.log('sendRejectEmail called with email:', email);
    fetch('/email/reject', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email }),
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch((error) => console.error('Error:', error))
}