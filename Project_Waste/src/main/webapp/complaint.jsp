<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register Complaint</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<!--<link rel="stylesheet" href="css/style.css">-->
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

	<div class="main">

		<!-- Complaint form -->
		<section class="complaint">
			<div class="container">
				<div class="complaint-content">
					<div class="complaint-form">
						<h2 class="form-title">Register Complaint</h2>
					
						<form method="post" action="complaint" class="ComplaintServlet-form"
							id="ComplaintServlet-form">
							<div class="mb-4">
                                <label>Full Name  : </label>
                                <input type="text" name="name" id="name" placeholder="Enter full name" required />
                             </div>
                             <hr>
                             <div class="mb-4">
                                <label>Email Address  : </label>
                                <input type="text" name="email" id="email" placeholder="Enter email address" required />
                             </div>   
                             <hr>
                             <div class="mb-4">
                                <label>Phone Number  :</label>
                                <input type="text" name="phno" id="phno" placeholder="Enter Phone Number" required />
                             </div>
                             <hr>
                            <div class="mb-4">
                                 <label>Complaint Details :</label>
                                 <input type="textarea" name="complaint" id="complaint" placeholder="Enter your complaint in details" required/>
                            </div>
							<div class="mb-8 form-button">
								<input type="submit" value="Submit" />
							</div>
							
						</form>
					</div>
					
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
  var status=document.getElementById("status").value;
  if(status=="success"){
	  swal("Congratulations","Order Registerd Successfully","success");
  }else if(status=="failed"){
	  swal("Sorry","Invalid Data","error");
  }
</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>