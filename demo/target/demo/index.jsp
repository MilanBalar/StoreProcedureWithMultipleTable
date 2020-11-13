<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RegistrationForm</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- LINEARICONS -->
		<link rel="stylesheet" href="fonts/linearicons/style.css">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- DATE-PICKER -->
		<link rel="stylesheet" href="vendor/date-picker/css/datepicker.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/style.css">
	</head>

	<body>

		<div class="wrapper">
			<div class="inner">
				<form action="save" method="post">
					<h3>Registration</h3>
					<div class="form-row">
						<div class="form-wrapper">
							<label for="">Name *</label>
							<input type="text" class="form-control" name="sname" placeholder="Your Name">
						</div>
						<div class="form-wrapper">
							<label for="">Email *</label>
							<input type="text" class="form-control" name="semail" placeholder="Phone">
						</div>
					</div>
					<div class="form-row">
						<div class="form-wrapper">
							<label for="">Contact Number *</label>
						
							<input type="text" class="form-control datepicker-here" data-language='en' name="scontact" id="dp1">
						</div>
						<div class="form-wrapper">
							<label for="">City *</label>
							
							<input type="text" class="form-control datepicker-here" data-language='en'  name="scity" id="dp2">
						</div>
					</div>
					
					<div class="form-row">
						
						<div class="form-wrapper">
							<label for="">Password *</label>
							
							<input type="text" class="form-control datepicker-here" data-language='en'  name="spwd" id="dp2">
						</div>
					</div>
					
					<div class="checkbox">
						<label>
							<input type="checkbox"> No one rejects, dislikes, or avoids pleasure itself.
							<span class="checkmark"></span>
						</label>
						<button data-text="Book Room">
						<span>Register</span>
					</button>
					<form action="login">
		<button data-text="Book Room">
						<span>Login</span>
					</button>
		
		</form>
					</div>
					
				</form>
			</div>
		</div>
		
		
		<script src="js/jquery-3.3.1.min.js"></script>

		<!-- DATE-PICKER -->
		<script src="vendor/date-picker/js/datepicker.js"></script>
		<script src="vendor/date-picker/js/datepicker.en.js"></script>

		<script src="js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>