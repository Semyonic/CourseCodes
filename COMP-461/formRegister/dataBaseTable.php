<html><head><title>Guess !!!</title></head>
<link rel="favicon" type="image/png" href="/favicon.ico"/>
<br></br>
<br></br>
<br></br>
<br></br>
<center><div id="Sign-Up">
        <fieldset style="width:25%"><legend>Register</legend>
        <table border="0">
        <form method="POST" action="db.php">
        <tr>
        <td>First Name</td><td> <input type="text" name="firstName" maxlength="8"></td>
        </tr>
        <tr>
        <td>Last Name</td><td> <input type="text" name="lastName" maxlength="8"></td>
        </tr>
        <tr>
        <td>Phone Number</td><td> <input type="text" name="phoneNumber" maxlength="11"></td>
        </tr>
        <tr>
        <td><input id="button" type="submit" name="submit" value="Sign-Up"></td>
        </tr>
        </form> </table></fieldset></div></center>

<?php

//DataBase credentials
$servername = "localhost";
$username = "root";
$password = "dYn6fGF0";
$dbname = "register";

//MySQL Connection for user registration
$con=mysql_connect($servername,$username,$password) or die("Failed to connect to MySQL: " . mysql_error());
$db=mysql_select_db($dbname,$con) or die("Failed to connect to MySQL: " . mysql_error());

//Getting new user registration info brom textBoxes and passing it into SQL query
function NewUser()
{
        $FirstName = $_POST['firstName'];
        $LastName = $_POST['lastName'];
        $PhoneNumber =  $_POST['phoneNumber'];
        $query = "INSERT INTO Persons (FirstName,LastName,PhoneNumber) VALUES ('$FirstName','$LastName','$PhoneNumber')";
        $data = mysql_query ($query)or die(mysql_error());
        if($data)
        {
        echo "";
        }
}

//Preventation of duplicate registrations
function SignUp()
{
if(!empty($_POST['firstName']))
{
        $query = mysql_query("SELECT * FROM Persons WHERE FirstName = '$_POST[firstName]' AND phoneNumber = '$_POST[phoneNumber]'") or die(mysql_error());

        if(!$row = mysql_fetch_array($query) or die(mysql_error()))
        {
                newuser();
        }
        else
        {
                echo "Already registered with same name !";
        }
}
}
if(isset($_POST['submit']))
{
        SignUp();
}

//Creating HTML table
echo "<table style='border: solid 1px black;'>";
echo "<tr><th>First Name</th><th>Last Name <th>Phone Number</th></th></tr>";

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

//New connection to DataBase via PDO for filling values into to table
try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $stmt = $conn->prepare("SELECT FirstName,LastName,PhoneNumber FROM Persons ORDER BY PersonID DESC"); 
    $stmt->execute();

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
echo "</table></html>";
?>
