import org.junit.Assert;
import org.junit.Test;
import utils.Stack;
import java.util.Optional;

public class StackTest {

    @Test
    public void pushTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(78);
        stack.push(105);
        Assert.assertEquals(Optional.of(105), stack.peek());
        Assert.assertEquals(3, stack.size());
    }

    @Test
    public void popTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(78);
        stack.push(105);
        stack.pop();

        Assert.assertEquals(Optional.of(78), stack.peek());
        Assert.assertNotEquals(Optional.of(105), stack.peek());
        Assert.assertEquals(2, stack.size());
    }

    @Test
    public void pop_empty_Test(){
        Stack<Integer> stack = new Stack<>();
        Optional<Integer> element = Optional.ofNullable(stack.pop());

        Assert.assertTrue(element.isEmpty());
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void peek_empty_Test(){
        Stack<Integer> stack = new Stack<>();
        Optional<Integer> element = Optional.ofNullable(stack.peek());

        Assert.assertTrue(element.isEmpty());
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void is_EmptyTest(){
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void is_not_EmptyTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        Assert.assertFalse(stack.isEmpty());
    }
}
