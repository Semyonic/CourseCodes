<?php 
session_start();
echo "Current User : " .$_SESSION['username'];
?>
<?php
$score = $_POST['score'];
$operator = $_POST['operator'];
$first = $_POST['first'];
$second = $_POST['second'];
$answ = $_POST['answer'];

if ($operator == '+') {
	$result = $first + $second;
} elseif ($operator == '-') {
	$result = $first - $second;
} elseif ($operator == '*') {
	$result = $first * $second;
} else {
	$result = $first / $second;
}
?>
<html><head><title>Reuslts</title></head><body>
<?php
$userName = $_SESSION['username'];

if ($result == $answ) {
	$score++;
	echo "<br></br>";
        echo "<br></br>";
	echo "<center><img src='correct.jpg'  style='width:304px;height:228px'></center>";
	echo "<form name = \"Guess\" action  = \"index.php\" method = \"POST\">";
	echo "<input type = \"hidden\" name =\"score\" value = '$score' method=\"POST\">";
	echo "<center><br> <input type= \"submit\" value = \"Continue\"></center>";
} else {
	$score--;
	echo "<br></br>";
        echo "<br></br>";
	echo "<center><img src='wrong.jpg' style='width:304px;height:228px'></center>";
	echo "<br></br>";
	echo "<br></br>";
	echo "<form name = \"Guess\" action  = \"index.php\" method = \"POST\">";
	echo "<center><br> <input type= \"submit\" value = \"Try Again\"></center>";
	echo "<input type = \"hidden\" name =\"score\" value = '$score' method=\"POST\">";
	echo "<form name = \"Scores\" action  = \"index.php\" method = \"POST\">";
}
echo "</body></html>";


$servername = "localhost";
$username = "root";
$password = "dYn6fGF0";
$dbname = "users";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "UPDATE Users SET score='$score' WHERE nickName='$userName'";

if (mysqli_query($conn, $sql)) {
    echo "";
} else {
    echo "Error updating record: " . mysqli_error($conn);
}
mysqli_close($conn);
?>
