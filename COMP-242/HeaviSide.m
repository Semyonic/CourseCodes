t=0:99
u=heaviside(t)

h=heaviside(t)-heaviside(t-2)
i=0;

for t1=-1:0.1:1
    i=i+1;
    if t1<0
        x(i)=(t1+1)
    else
        x(i)=(-t1+1)
    end
end

y=conv(x,h)

plot(y)
