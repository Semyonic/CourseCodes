%Semih Onay - 11176008

%Putted semicolons to hide matrices

%Question-1-a
A = [1 2; 4 8];
I = eye(2,2);
compair_A = isequal(A*I,I*A)

%Question-1-b
B = [1 0 2; 3 -2 4; 0 0 -5];
I2 = eye(3,3);
compair_B = isequal(B*I2,I2*B)

%Question-2
M = det([-3 1; -2 -4])

%Question-3-a
C = [5 -3 -2; -2 2 0; -5 2 3];
if eq(det(C),0)
    fprintf('Singular\n')
else
    fprintf('Non-singular\n')
end

%Question-3-b
D = [0 2 2; -3 1 2; -2 0 0];

if eq(det(D),0)
    fprintf('Singular\n')
else
    fprintf('Non-singular\n')
end

E1 = [1 2 ; 3 4];
E2 = [1 1 ; 3 5];

ans1 = inv((E1*E2));
ans2 = inv(E1)*inv(E2);
ans3 = inv(E2)*inv(E1);

fprintf('\n');

%Converting answer matrices to Un-signed 8-bit integer matrix.
%It looks 'isequal' only works with integers not doubles.
one = uint8(ans1);
two = uint8(ans2);
three = uint8(ans3);

%Conditions for testing matrix equality
if isequal(one,two)
    fprintf('Equal\n')
else
    fprintf('NotEqual\n')
end

if isequal(one,three)
    fprintf('Equal\n')
else
    fprintf('NotEqual\n')
end

if isequal(two,three)
    fprintf('Equal\n')
else
    fprintf('NotEqual\n')
end
