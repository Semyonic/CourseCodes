clear all
syms t;

T0 = 5;
k_vec = [-10:10];

w0=2*pi/T0

% !!!IMPORTANT!!!: the signal definition must cover [0 to T0]
% the signal is defined over [-T0, 2T0], which covers [0, T0]
%xt = heaviside(t+1)-heaviside(t-1) + heaviside(t-(T0-1/2))-heaviside(t-(T0+1/2));
xt=heaviside(t)-heaviside(t-T0/2)-heaviside(t-T0/2)+heaviside(t-T0);

%xt=sin(2*pi*t/T0)

[Xw, w] = FourierSeries(xt, T0, k_vec);
% plot the results from Matlab calculation

xt_prediction=0;

t1=0:0.1:T0

for i=1:length(k_vec)
    
    k=k_vec(i);
    
    x=Xw(i)*exp(j*k*w0*t);
    
    xt_prediction=xt_prediction+x;
    
end

ezplot(xt)

figure

ezplot(xt_prediction)
   

