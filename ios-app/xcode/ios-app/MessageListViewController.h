//
//  MessageListViewController.h
//  ios-app
//
//  Created by Trung Le on 10/19/17.
//  Copyright © 2017 nimbl3. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MessageListViewController : UIViewController
@property (weak, nonatomic) IBOutlet UITableView *messageTableView;
@property (weak, nonatomic) IBOutlet UITextField *ErrorMessage;

@end
