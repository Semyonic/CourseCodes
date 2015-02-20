/*
 * 
#        _  _  _  _                                     _     _                        _  _  _  _                                                  
#      _(_)(_)(_)(_)_                                  (_)   (_)                     _(_)(_)(_)(_)_                                                
#     (_)          (_)  _  _  _  _     _  _   _  _   _  _    (_) _  _  _            (_)          (_) _  _  _  _      _  _  _    _               _  
#     (_)_  _  _  _    (_)(_)(_)(_)_  (_)(_)_(_)(_) (_)(_)   (_)(_)(_)(_)_          (_)          (_)(_)(_)(_)(_)_   (_)(_)(_) _(_)_           _(_) 
#       (_)(_)(_)(_)_ (_) _  _  _ (_)(_)   (_)   (_)   (_)   (_)        (_)         (_)          (_)(_)        (_)   _  _  _ (_) (_)_       _(_)   
#      _           (_)(_)(_)(_)(_)(_)(_)   (_)   (_)   (_)   (_)        (_)         (_)          (_)(_)        (_) _(_)(_)(_)(_)   (_)_   _(_)     
#     (_)_  _  _  _(_)(_)_  _  _  _  (_)   (_)   (_) _ (_) _ (_)        (_)         (_)_  _  _  _(_)(_)        (_)(_)_  _  _ (_)_    (_)_(_)       
#       (_)(_)(_)(_)    (_)(_)(_)(_) (_)   (_)   (_)(_)(_)(_)(_)        (_)           (_)(_)(_)(_)  (_)        (_)  (_)(_)(_)  (_)    _(_)         
#                                                                                                                                _  _(_)           
#                                                                                                                               (_)(_)             
 * The MIT License
 *
 * Copyright 2013 Semih Onay <semih.onay@bilgiedu.net>.
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package project04;

/**
 * 
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Semih
 */
public class Main {

    public static void main(String[] args) {

        LinkofObject item = new LinkofObject(1, null);
        LinkofObject item2 = new LinkofObject(1, null);
        LinkofObject item3 = new LinkofObject(1, null);
        LinkofObject item4 = new LinkofObject(1, null);
        LinkofObject item5 = new LinkofObject(1, null);

        item.rest = item;
        item2.rest = item2;
        item3.rest = item3;
        item4.rest = item4;
        item5.rest = item5;

    }

}
