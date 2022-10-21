<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:fragment="head">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Product Management</title>

    <style type="text/css">
        h3{background-color: blue; color: white; padding: 10px 0 10px 20px;}
        footer{margin: 10px 0;}

        #products {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #products td, #products th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #products tr:nth-child(even){background-color: #f2f2f2;}

        #products tr:hover {background-color: #ddd;}

        #products th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }

        input[type=text],input[type=email]{
            width: 100%;
            padding: 12px 0px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 300px;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        #form {
            width: 500px;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .notify span{font-size: 15px; color: blue;}
    </style>
</head>
<body>

<footer th:fragment="footer">
    &copy; 2021 CodeGym
</footer>
</body>
</html>