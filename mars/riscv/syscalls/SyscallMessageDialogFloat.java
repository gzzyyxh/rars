package mars.riscv.syscalls;

import mars.ExitingException;
import mars.ProgramStatement;
import mars.riscv.AbstractSyscall;
import mars.riscv.hardware.FloatingPointRegisterFile;

import javax.swing.*;

/*
Copyright (c) 2003-2008,  Pete Sanderson and Kenneth Vollmar

Developed by Pete Sanderson (psanderson@otterbein.edu)
and Kenneth Vollmar (kenvollmar@missouristate.edu)

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the 
"Software"), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, 
distribute, sublicense, and/or sell copies of the Software, and to 
permit persons to whom the Software is furnished to do so, subject 
to the following conditions:

The above copyright notice and this permission notice shall be 
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

(MIT license, http://www.opensource.org/licenses/mit-license.html)
 */

public class SyscallMessageDialogFloat extends AbstractSyscall {
    public SyscallMessageDialogFloat() {
        super("MessageDialogFloat", "Service to display a message followed by a float to user",
                "a0 = address of null-terminated string that is the message to user <br>" +
                        "fa1 = the float to display", "N/A");
    }

    public void simulate(ProgramStatement statement) throws ExitingException {
        String message = NullString.get(statement);

        // Display the dialog.
        JOptionPane.showMessageDialog(null,
                message + Float.toString(FloatingPointRegisterFile.getFloatFromRegister("fa1")),
                null,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
