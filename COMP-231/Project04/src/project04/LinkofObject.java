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
public class LinkofObject {

    /**
     * Data Definitions:
     *
     * LinkofInt
     *
     * -empty -contains one object + rest of the list
     *
     */
    Object first;
    LinkofObject rest;

    /**
     *
     * @param first 1st element in list
     * @param rest rest elements in rist
     */
    public LinkofObject(Object first, LinkofObject rest) {
        this.first = first;
        this.rest = rest;
    }

    /**
     *
     * @param obj is link of the object
     */
    @SuppressWarnings("AssignmentToMethodParameter")
    public void printList(LinkofObject obj) {

        if (obj != null) {

            System.out.println(obj.toString());
            obj = obj.rest;
            printList(obj);
        }

    }

    /**
     *
     * @param obj is link of the object
     * @return applies filter on given linked-object
     */
    @SuppressWarnings({"AssignmentToMethodParameter", "UnusedAssignment", "null"})
    public LinkofObject filterNulls(LinkofObject obj) {

        LinkofObject previous = null;

        while (obj != null) {

            if (obj.first == null) {

                previous = new LinkofObject(obj.first, null);
            }
            previous.rest = obj.rest;
            obj = obj.rest;
        }

        return obj;
    }

    @Override
    public String toString() {

        return this.first.toString();
    }

}