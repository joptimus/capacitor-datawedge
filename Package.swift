// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorDatawedge",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorDatawedge",
            targets: ["DataWedgePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "DataWedgePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/DataWedgePlugin"),
        .testTarget(
            name: "DataWedgePluginTests",
            dependencies: ["DataWedgePlugin"],
            path: "ios/Tests/DataWedgePluginTests")
    ]
)