<?php

define('DB_HOST', 'localhost');
define('DB_NAME', 'users');
define('DB_USER','root');
define('DB_PASSWORD','dYn6fGF0');

$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: " . mysql_error());
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error());


function NewUser()
{
	$nickName = $_POST['nick'];
	$email = $_POST['email'];
	$password =  $_POST['pass'];
	$query = "INSERT INTO Users (nickName,email,password) VALUES ('$nickName','$email','$password')";
	$data = mysql_query ($query)or die(mysql_error());
	if($data)
	{
	echo "Registiration completed, you'll be redirected to homePage in 5 seconds ";
	echo "<html><head><title>Registered !</title><meta http-equiv='refresh' content='5;URL=index.php'/></head></html>";
	}
}

function SignUp()
{
if(!empty($_POST['nick']))   //checking the 'user' name which is from Sign-Up.html, is it empty or have some text
{
	$query = mysql_query("SELECT * FROM Users WHERE nickName = '$_POST[nick]' AND password = '$_POST[pass]'") or die(mysql_error());

	if(!$row = mysql_fetch_array($query) or die(mysql_error()))
	{
		newuser();
	}
	else
	{
		echo "SORRY...YOU ARE ALREADY REGISTERED USER...";
	}
}
}
if(isset($_POST['submit']))
{
	SignUp();
}
?>
