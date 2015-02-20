<?php 
session_start();
echo "Current User : " .$_SESSION['username'];

//Check whether the session variable SESS_MEMBER_ID is present or not
/*if(!isset($_SESSION['username'])) {
	header("location: login.html");
	exit();
}
*/

?>
<html><head><title>Guess !!!</title></head>
<?php
echo "<table style='border: solid 1px black;'>";
echo "<tr><th>Nick Name</th><th>Score</th></tr>";

class TableRows extends RecursiveIteratorIterator { 
    function __construct($it) { 
        parent::__construct($it, self::LEAVES_ONLY); 
    }

    function current() {
        return "<td align='center' style='width:20px;border= 0 red;'>" . parent::current(). "</td>";
    }

    function beginChildren() { 
        echo "<tr>"; 
    } 

    function endChildren() { 
        echo "</tr>" . "\n";
    } 
} 

//echo "<form method='POST' action='register.html'>";
//echo "<center><input type='submit' value='Register'></center>";
//echo "</form>";
$servername = "localhost";
$username = "root";
$password = "dYn6fGF0";
$dbname = "users";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $stmt = $conn->prepare("SELECT nickName, score FROM Users ORDER BY score DESC"); 
    $stmt->execute();

    // set the resulting array to associative
    $result = $stmt->setFetchMode(PDO::FETCH_ASSOC); 

    foreach(new TableRows(new RecursiveArrayIterator($stmt->fetchAll())) as $k=>$v) { 
        echo $v;
    }
    $dsn = null;
    }
catch(PDOException $e)
    {
    echo "Error: " . $e->getMessage();
    }
$conn = null;
echo "</table>";
?>
<?php

//Check whether the session variable SESS_MEMBER_ID is present or not
//if(!isset($_SESSION['sess_user_id']) || (trim($_SESSION['sess_user_id']) == '')) {
//	header("location: login.html");
//	exit();
//}

$scores = $_POST['score'];
$randOp = rand(1,4);

	if ($randOp == 1) {
        	$operator = '+';
	} elseif ($randOp == 2) {
        	$operator = '-';
	} elseif ($randOp == 3) {
        	$operator = '*';
	} else {
        	$operator = '/';
	}

	if ($scores > 5) {
		$first = rand(10,20);
		$second = rand(10,20);
	} elseif ($scores > 10) {
		$first = rand(20,30);
		$second= rand(20,30);
	} elseif ($scores > 20) {
		$first = rand(30,80);
		$second = rand(30,80);
	} elseif ($scores > 20) {
        	$first = rand(40,90);
        	$second = rand(40,90);
	} elseif ($scores > 30) {
        	$first = rand(50,100);
        	$second = rand(50,100);
	} else {
		$first = rand(1,10);
		$second = rand(1,10);
	}
?>
<h1><center> <?php echo $first; ?> <?php echo $operator; ?> <?php echo $second; ?> = ?</center></h1>
<form name = "Guess" action  = "calc.php" method = "POST">
<center><input type = "text" name = "answer"></center> <form action = "calc.php" method ="POST"
<h1><center> Score </center></h1>
<h1><center> <?php echo $scores; ?> </center></h1>
<center> <input type= "submit" value = "Send"></center>
<br></br>
<center><input type="button" onClick="history.go(0)" value="Click to Skip Question">
<br></br>
<input type = "hidden" name ="first" value ="<?php echo $first; ?>" method="POST">
<input type = "hidden" name ="second" value ="<?php echo $second; ?>" method="POST">
<input type = "hidden" name ="operator" value ="<?php echo $operator; ?>" method="POST">
<input type = "hidden" name ="score" value ="<?php echo $scores; ?>" method="POST"></form>
<br></br>
<br></br>
<form method="POST" action="login.html">
<center><input type="submit" action="login.html" value="Login"></center></form>
<form method="POST" action="logout.php">
<center><input type="submit" action="logout.php" value="Logout"></center></form></html>
