#include <linux/module.h>
#include <linux/kernel.h>

int init_module(void) {
    printk(KERN_INFO "Hello, Joseph Rissman!\n");
    return 0;
}

void cleanup_module(void) {
    printk(KERN_INFO "Goodbye, Joseph Rissman!\n");
    return;
}

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("My first cool kernel module");
MODULE_AUTHOR("Joseph Rissman");
