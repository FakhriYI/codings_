<?php
session_start();

if (!isset($_SESSION['web-b']['username'])) {
	header("location:login.php");
	exit();
}

const INDEX = 'yes';

?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Administrator Web</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/navbar-fixed-top.css" rel="stylesheet">
	
	<!-- panggil css summernote -->
	<link href="summernote/summernote.css" rel="stylesheet">
	
	<!-- panggil css fancybox -->
	<link href="css/jquery.fancybox.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">
		  <span class="glyphicon glyphicon-grain"></span>
		  Administrator
		  </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.php">Home</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artikel <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="index.php?page=input-artikel">Tambah Artikel</a></li>
                <li><a href="index.php?page=data-artikel">Data Artikel</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			  <span class="glyphicon glyphicon-user"></span>
			  <?php echo $_SESSION['web-b']['nama']; ?>
			  <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="logout.php">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
	<?php
	if (isset($_GET['page'])) {
		
		switch($_GET['page']) {
			case "data-artikel":
				include("page/artikel/data_artikel.php");
			break;
			
			case "input-artikel":
				include("page/artikel/input_artikel.php");
			break;
			
			case "edit-artikel":
				include("page/artikel/edit_artikel.php");
			break;
			
			default:
				echo '<h1 align="center">404 - PAGE NOT FOUND!</h1>';
			break;
		}
		
	} else {
		include("home.php");
	}
	?>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
	
	<script src="summernote/summernote.min.js"></script>
	
	<script src="js/jquery.fancybox.min.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#konten").summernote({
			height: 250
		});
		
		
		$(".btn-hapus").on("click", function(e){
			e.preventDefault();
			
			var urlhapus = $(this).attr("href");
			$("#btn-iya").attr("href", urlhapus);
			
			$("#confirm-artikel").modal({
				backdrop: 'static',
				keyboard: false
			});
		});
	});
	</script>
  </body>
</html>
