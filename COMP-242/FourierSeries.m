function [X, w] = FourierSeries(x, T0, k_vec)

% x: the time domain signal within one period; 
%    it must have definition over [0, T0]
%    it must be a symbolic function of t%       
% T0: the period of the signal
% k_vec: the range of Harmonics to be calculated
syms t
for mm = 1:length(k_vec)
    k = k_vec(mm); 
% Fourier series 
X1(mm) = int(x*exp(-j*2*pi*k*t/T0), t, 0, T0)/T0;
    % change the symbolic value to numerical value
X(mm) = subs(X1(mm));
    % angular frequency
w(mm) = k*2*pi/T0;
end

end
