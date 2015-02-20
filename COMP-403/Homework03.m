function Tutorial_Noise_SNR()

%{
To read the original image, add noise and write the noisy picture in the
directory.
%}

original_image='cameraman.jpg';

%Reading the image
img2D = imread(original_image);%256*256 uint8
%Looking at the original picture
imshow(uint8(img2D));
title('Original image');

%ADDING SALT&PEPPER NOISE
salt_PepperNoise = imnoise(img2D,'salt & pepper',0.09);
imshow(uint8(salt_PepperNoise))
title('Original image corrupted with Salt&Pepper noise');

%CALCULATING SNR OF SALT&PEPPER NOISE
double_img2=double(img2D);
saltPepper_SNR=SNR(double_img2,double(salt_PepperNoise));
fprintf (' %f \n' ,saltPepper_SNR);

%{
ADDING GAUSSIAN NOISE
Method1: Using a ready function of MATLAB
Do check the help of imnoise(): the parameters must be specified
as the image was of class double [0,1]. But we do NOT need to normalize
the image; it works also with uint8 pictures!
%}

G_var=(14/255)^2;
Gauss14_v1=imnoise(img2D, 'gaussian', 0, G_var);

%Looking at the noisy picture, version 1 (v1):
figure; imshow(Gauss14_v1); title('Original image corrupted with Gaussian noise,v1, sigma = 14');

%Writing the corrupted picture into the directory
imwrite(Gauss14_v1, 'Gauss14.jpg');

%{
Method2: like in the scanned pages about noise
Generating a same size picture storing Gaussian noise, G(mean, var)
%}
G_mean=0;
[row,col]=size(img2D);
G_sigma=14;
G_sigma2=27;
G_noise=G_mean+G_sigma*randn(row,col);
G_noise2=G_mean+G_sigma2*randn(row,col);

%{
Creating the histogram of the noise, using 56 bins (because sigma=14 and
I am interested in the values between [-2*sigma 2*sigma]
I MUST pass a column vector
hist_Gauss14=hist(G_noise(:), 56);
plot(hist_Gauss14);
%}

hist(G_noise(:), 56); %For a better view
hist(G_noise2(:),56);
%Looking at the picture of the noisy
figure; imshow(G_noise, []); title('Gaussian noise, sigma = 14');
figure; imshow(G_noise2,[]); title('Gaussian noise, sigma = 27');

%{
Adding the noise to the original picture; when I work with noise the
image must be double!!!
%}
double_img2D=double(img2D);
Gauss14_v2=double_img2D+G_noise;
Gauss14_v3=double_img2D+G_noise2;

%Looking at the noisy picture, version 2 (v2):
figure; imshow(Gauss14_v2, []); title('Original image corrupted with Gaussian noise,v2, sigma = 14');
figure; imshow(Gauss14_v3,[]); title('Original image corrupted with Gaussian noise,v3, sigma = 27');

%UniformNoise Generation
img_Uniform = imread(original_image);
double_img_Uniform  = double(img_Uniform);
A = -47;
B = 47;
matrix_uniform = A + (B-A)*rand(size(img_Uniform));
Uniform_noisy_image = double_img_Uniform + matrix_uniform;
imshow(Uniform_noisy_image./255), 

%Checking the SNR values: it must be near
SNR_Gauss14_v1=SNR(double_img2D, double(Gauss14_v1));
fprintf ('SNR for Gauss_14_v1 %f \n' , SNR_Gauss14_v1);
SNR_Gauss14_v2=SNR(double_img2D, Gauss14_v2);
fprintf ('SNR for Gauss_14_v2 %f \n' , SNR_Gauss14_v2);
SNR_Gauss14_v3=SNR(double_img2D,Gauss14_v3);
fprintf ('SNR for Gauss_14_v3 %f \n' ,SNR_Gauss14_v3);
SNR_UniformNoise=SNR(double_img_Uniform,Uniform_noisy_image);
fprintf('SNR for UniformNoise %f \n',SNR_UniformNoise);

%{
HW3!!!!

3. Modify the original image by adding the uniform noise, [-47, 47]
4. Calculate the SNR ratio of the image corrupted with uniform noise
%}
end

function SNRdb=SNR(orig_image, noisy_image)

%{
It calculate the SNR ratio of the noisy images (before and after filtering
them. Clean images have inf SNR value.
Important: Images in MATLAB are unint8, this means that all greylevels
are [0,256]. When I work with noise, if-when I convert to unint8 I do
loose all negative values!!!
%}
top=sum(sum(noisy_image.^2));
bottom=sum(sum((noisy_image-orig_image).^2));
SNR=top/bottom;
%More used: SNRdb=log10SNR
SNRdb=10*log10(top/bottom); %Decibel
end