<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Driver Registration</title>
<style>
  body {
    font-family: sans-serif;
  }
  form {
    display: flex;
    flex-direction: column;
    gap: 1rem;
    width: 300px;
    margin: 0 auto;
  }
  label {
    display: block;
    margin-bottom: 5px;
  }
  input[type="text"], textarea {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
</style>
</head>
<body>
  <h2>Driver Registration Form</h2>
  <form action="driverreg" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br><br>
    <label for="aadharNumber">Aadhar Number:</label>
    <input type="text" name="aadharNumber" id="aadharNumber" minlength="12" maxlength="12" required><br><br>
    <label for="address">Address:</label>
    <textarea name="address" id="address" rows="4" cols="50" required></textarea><br><br>
    <label for="state">State:</label>
    <input type="text" name="state" id="state" required><br><br>
    <label for="city">City:</label>
    <input type="text" name="city" id="city" required><br><br>
     <label for="pincode">Pin Code:</label>
    <input type="text" name="pin code" id="pin" required><br><br>
     <label for="exp">Experience:</label>
    <input type="text" name="exp" id="exp" required><br><br>
  
     <label for="email">Email:</label>
    <input type="text" name="email" id="email" required><br><br>
     <label for="pass">Password:</label>
    <input type="text" name="pass" id="pass" required><br><br>
     <label for="conpass">Confirm Password:</label>
    <input type="text" name="conpass" id="conpass" required><br><br>
    <input type="submit" value="Register">
  </form>
</body>
</html>
