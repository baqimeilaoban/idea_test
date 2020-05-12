package cn.designpattern.bridge;

public interface Computer {
    void sale();
}

class Desktop implements Computer{

    @Override
    public void sale() {
        System.out.println("����̨ʽ����");
    }
}

class Laptop implements Computer{

    @Override
    public void sale() {
        System.out.println("���۱ʼǱ���");
    }
}

class Pad implements Computer{

    @Override
    public void sale() {
        System.out.println("����ƽ����ԣ�");
    }
}

class LenvoDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("��������̨ʽ����");
    }
}

class LenvoLaptop extends Desktop{
    @Override
    public void sale() {
        System.out.println("��������ʼǱ���");
    }
}

class LenvoPad extends Desktop{
    @Override
    public void sale() {
        System.out.println("��������ƽ����ԣ�");
    }
}

class ShenzhouDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("��������̨ʽ��");
    }
}
class ShenzhouLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("�������۱ʼǱ�");
    }
}
class ShenzhouPad extends Pad {
    @Override
    public void sale() {
        System.out.println("��������ƽ�����");
    }
}


class DellDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("���۴���̨ʽ��");
    }
}
class DellLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("���۴����ʼǱ�");
    }
}
class DellPad extends Pad {
    @Override
    public void sale() {
        System.out.println("���۴���ƽ�����");
    }
}
