FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://lastandfast-prompt.sh"

do_install:append() {
    echo "inari" > ${D}${sysconfdir}/hostname

    cat > ${D}${sysconfdir}/fstab << 'EOF'
# Lastandfast fstab
# Root filesystem - read only
/dev/root       /               ext4    ro,noatime,errors=remount-ro    0 1

# Data partition - read write for logs and runtime data
/dev/mmcblk0p2  /data           ext4    rw,noatime                      0 2

# Temporary writable overlay in RAM
tmpfs           /tmp            tmpfs   rw,nosuid,nodev,size=256m       0 0
tmpfs           /run            tmpfs   rw,nosuid,nodev,size=64m        0 0
EOF

    echo 'PRETTY_NAME="Lastandfast OS 1.0 (INAR)"' > ${D}${sysconfdir}/os-release
    echo 'NAME="Lastandfast OS"' >> ${D}${sysconfdir}/os-release
    echo 'VERSION="1.0"' >> ${D}${sysconfdir}/os-release
    echo 'ID=lastandfast' >> ${D}${sysconfdir}/os-release

    cat > ${D}${sysconfdir}/motd << 'EOF'

    ██╗      █████╗ ███████╗████████╗ █████╗ ███╗   ██╗██████╗ ███████╗ █████╗ ███████╗████████╗
    ██║     ██╔══██╗██╔════╝╚══██╔══╝██╔══██╗████╗  ██║██╔══██╗██╔════╝██╔══██╗██╔════╝╚══██╔══╝
    ██║     ███████║███████╗   ██║   ███████║██╔██╗ ██║██║  ██║█████╗  ███████║███████╗   ██║
    ██║     ██╔══██║╚════██║   ██║   ██╔══██║██║╚██╗██║██║  ██║██╔══╝  ██╔══██║╚════██║   ██║
    ███████╗██║  ██║███████║   ██║   ██║  ██║██║ ╚████║██████╔╝██║     ██║  ██║███████║   ██║
    ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝ ╚═╝     ╚═╝  ╚═╝╚══════╝   ╚═╝

    INAR Robotic Arm System
    Powered by Lastandfast OS 1.0
    ----------------------------------------------
    Host: inari | ROS 2 Humble | Jetson Orin Nano
    ----------------------------------------------
EOF

    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/lastandfast-prompt.sh ${D}${sysconfdir}/profile.d/
}
