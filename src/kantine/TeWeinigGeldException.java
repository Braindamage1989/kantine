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
    TeWeinigGeldException()
    {
        super("Te weinig geld!");
    }
    
    TeWeinigGeldException(Exception e)
    {
        super(e);
    }
    
    TeWeinigGeldException(String message)
    {
        super(message);
    }
}
