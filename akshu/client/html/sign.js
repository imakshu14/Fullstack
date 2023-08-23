document.addEventListener('DOMContentLoaded', () => {
  const signupForm = document.getElementById('signupForm');
  const loginForm = document.getElementById('loginForm');

  signupForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const name = document.getElementById('signup-user').value;
    const email = document.getElementById('signup-email').value;
    const password = document.getElementById('signup-password').value;

    const user = {
      name: name,
      email: email,
      password: password
    };

    try {
      const response = await fetch('http://localhost:8085/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*'
        },
        body: JSON.stringify(user)
      });

      if (response.status === 200) {
        console.log('Signup successful');
        localStorage.setItem("name", name);
        window.location.href = 'http://127.0.0.1:5500/client/spotify/';
      } else {
        console.error('Signup failed');
      }
    } catch (error) {
      console.error('Error during signup:', error);
    }
  });

  loginForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const email = document.getElementById('signin-email').value;
    const password = document.getElementById('signin-password').value;

    const userlogin = {
      email: email,
      password: password
    };

    try {
      const response = await fetch('http://localhost:8085/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*'
        },
        body: JSON.stringify(userlogin)
      });

      if (response.status === 200) {
        const responseData = await response.json();
        if (responseData === null) {
          alert('Wrong Email or password');
        } else {
          console.log('Login successful');
          localStorage.setItem("name", responseData.name);
          window.location.href = 'http://127.0.0.1:5500/client/spotify/';
        }
      } else {
        console.error('Login failed');
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  });
});
