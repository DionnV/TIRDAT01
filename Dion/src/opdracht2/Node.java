/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opdracht2;

import opdracht1.*;

/**
 *
 * @author Dion
 */
public class Node {
    
    private Object _data;
    private Node _next;
    private Node _previous;
    
    /** Constructor
     * 
     * @param data de data
     */
    public Node(Object data)
    {
        _data = data;
    }

    /** Zet de data
     * 
     * @param data de gewenste data
     */
    public void setData(Object data) {
        _data = data;
    }   

    /** Zet de volgende Node
     * 
     * @param next de gewenste volgende Node
     */
    public void setNext(Node next) {
        _next = next;
    }
    
    /** Retourneert de data.
     * 
     * @return de data.
     */
    public Object getData()
    {
        return _data;
    }
    
    /** Retourneert de volgende Node.
     * 
     * @return de volgende Node.
     */
    public Node getNext()
    {
        return _next;
    }
    
    /** Retourneert de vorige Node.
     * 
     * @return de vorige Node.
     */
    public Node getPrevious()
    {
        return _previous;
    }
    
    /** Zet de vorige Node.
     * 
     * @param previous de gewenste vorige Node.
     */
    public void setPrevious(Node previous)
    {
        _previous = previous;
    }
    
    /** Retourneert een string met data.
     * 
     * @return een string met data.
     */
    @Override
    public String toString()
    {
        return _data.toString();
    }
}
