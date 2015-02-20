<?php
ob_start();
session_start();
 
$username = $_POST['username'];
$password = $_POST['password'];
 
$conn = mysql_connect('localhost', 'root', 'dYn6fGF0');
mysql_select_db('users', $conn);
 
$username = mysql_real_escape_string($username);
$query = "SELECT nickName, password
        FROM Users
        WHERE nickName = '$username';";
 
$result = mysql_query($query);
 
if(mysql_num_rows($result) == 0)
{
// User not found. So, redirect to login_form again.
    header('Location: login.html');
}
 
$userData = mysql_fetch_array($result, MYSQL_ASSOC);

// Incorrect password. So, redirect to login_form again. 
if($password != $userData['password'])
{
    header('Location: login.html');
// Redirect to home page after successful login.

}else{
	session_regenerate_id();
	$_SESSION['username'] = $userData['nickName'];
	session_write_close();
	header('Location: index.php');
}
?>
