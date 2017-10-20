//
//  ChatViewController.h
//  ios-app
//
//  Created by Trung Le on 10/20/17.
//  Copyright © 2017 nimbl3. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ChatViewController : UIViewController
@property (weak, nonatomic) IBOutlet UITextField *input;
- (IBAction)submit:(id)sender;

@end
