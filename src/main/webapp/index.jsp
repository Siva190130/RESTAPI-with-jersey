<!DOCTYPE html>
<html>
<head>
    <title>Jersey RESTful Web Application</title>

    <style>
        body {
            margin: 0;
            padding: 0;

            /* Background image */
            background-image: url("resources/images/rest-basics.jpg");
            background-size: contain;       /* Fill entire screen */
            background-position: center;   /* Center the image */
            background-repeat: no-repeat;  /* No tiling */
            background-attachment: fixed;  /* Nice parallax feel */

            font-family: Arial, sans-serif;
        }

       .overlay {
				    background-color: rgba(0, 0, 0, 0.4);
				    height: 100vh;
				    color: white;
				
				    display: flex;
				    flex-direction: column;
				
				    justify-content: flex-start;   /* top */
				    align-items: flex-start;       /* left */
				
				    padding: 20px 30px;            /* spacing from edges */
				    text-align: left;
				}


        a {
            color: #00e5ff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class="overlay">
        <h2>Jersey RESTful Web Application!</h2>

        <p>
            <a href="webapi/myresource">Jersey resource</a>
        </p>

        <p>
            Visit
            <a href="http://jersey.java.net">Project Jersey website</a>
            for more information on Jersey!
        </p>
    </div>
</body>
</html>
