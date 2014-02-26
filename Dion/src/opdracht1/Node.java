/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opdracht1;

/**
 *
 * @author Dion
 */
public class Node {
    
    private Object _data;
    private Node _next;
    
    public Node(Object data)
    {
        _data = data;
    }

    public void setData(Object data) {
        _data = data;
    }   

    public void setNext(Node next) {
        _next = next;
    }
    
    public Object getData()
    {
        return _data;
    }
    
    public Node getNext()
    {
        return _next;
    }
    
    @Override
    public String toString()
    {
        return _data.toString();
    }
}
