%Exercise 5: HW2
%Let us import a color JPEG image and set some pixels to red, others to
%green, others to blue

%Red
img_RGB2=imread('trees_small.jpg');
 imshow(img_RGB2); title('Original RGB image')
 for counter=2:3
     img_RGB2(10:400,15:250,counter)=0;
 end
 figure; imshow(img_RGB2); title('RGB image with a Red box')

 %Green
img_RGB3=imread('trees_small.jpg');
  for counter2=3:3
     img_RGB3(50:400,55:250,counter2)=0;
 end
 figure; imshow(img_RGB3); title('RGB image with a Green box')
 
  %Blue
img_RGB4=imread('trees_small.jpg');
  for counter3=1:2
     img_RGB4(100:400,95:250,counter3)=0;
 end
 figure; imshow(img_RGB4); title('RGB image with a Blue box')
