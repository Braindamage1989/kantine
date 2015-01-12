/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kantine;

/**
 *
 * @author R
 */
public class TeWeinigGeldException extends Exception
{
    String s;
    
    TeWeinigGeldException()
    {
        
    }
    
    TeWeinigGeldException(Exception e)
    {
        
    }
    
    TeWeinigGeldException(String message)
    {
        s = message;
    }
    
    public String getS()
    {
        return s;
    }
}
