<?php

include("koneksi.php");

$username = $_POST['username'];
$password = md5($_POST['password']);

$sql_login = "SELECT * FROM `user` WHERE
			  username = '$username' AND password = '$password'";
			  
$result    = $koneksi->query($sql_login);

if ($result->num_rows > 0) {
	$data = $result->fetch_array();
	session_start();
	
	$_SESSION['web-b']['username'] = $data['username'];
	$_SESSION['web-b']['nama']     = $data['nama'];
	$_SESSION['web-b']['email']    = $data['email'];
	
	$koneksi->query("UPDATE `user` SET last_login = NOW() WHERE id = '$data[id]' ");
	
	header('location:index.php');
} else {
	header('location:login.php?status=gagal-login');
}
?>