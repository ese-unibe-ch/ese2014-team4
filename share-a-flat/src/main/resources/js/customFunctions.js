  function checkPassword(password, passwordRepeated)
  {
    if (password.value != passwordRepeated.value) {
    	passwordRepeated.setCustomValidity('Passwords do not match!');
    } else {
    	passwordRepeated.setCustomValidity('');
    }
  }