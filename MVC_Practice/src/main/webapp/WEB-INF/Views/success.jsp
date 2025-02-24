<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        p {
            margin: 10px 0;
        }
        .image {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Student Details</h2>
        <p><strong>Name:</strong> ${std.name}</p>
        <p><strong>Username:</strong> ${std.username}</p>
        <p><strong>Email:</strong> ${std.email}</p>
        <p><strong>Password:</strong> ${std.pass}</p>
    </div>
</body>
</html>
